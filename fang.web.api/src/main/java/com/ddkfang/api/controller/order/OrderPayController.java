package com.ddkfang.api.controller.order;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ddkfang.constant.OrderStatus;
import com.ddkfang.constant.OrderStatusUserDisney;
import com.ddkfang.constant.Payment;
import com.ddkfang.constant.UnionPayConstant;
import com.ddkfang.constant.UrlConstant;
import com.ddkfang.dao.entity.order.Order;
import com.ddkfang.dao.entity.order.UnionpayRes;
import com.ddkfang.service.order.IOrdersService;
import com.ddkfang.service.orderpay.union.IUnionPayService;
import com.ddkfang.service.orderpay.wx.IWxPayService;
import com.unionpay.acp.sdk.AcpService;

@RestController
@RequestMapping("/api/order/pay")
public class OrderPayController
{

	private final static Logger logger = LoggerFactory.getLogger(OrderPayController.class);

	@Autowired
	IOrdersService ordersService;

	@Autowired
	IUnionPayService unionPayService;

	@Autowired
	IWxPayService wxPayService;

	@RequestMapping(value = "unionpay", method = RequestMethod.GET)
	public void createOrder(@RequestParam(name = "order_id", required = true) String orderId, HttpServletResponse resp,
			HttpServletRequest request) throws Exception
	{
		Order or = ordersService.getOrdersById(orderId);
		//判断order是否过期
		if (or.getStatus() == 1)
		{
			if (or.getLastPayTime().before(new Date()))
			{

				String msg = URLEncoder.encode("订单超时", "UTF-8");
				String s = UrlConstant.PAYRESULT + "?msg=" + msg + "&redirect=" + UrlConstant.ORDERS;
				resp.sendRedirect(s);
			}
			String html = unionPayService.genPayData(or.getId(), or.getPrice(), "01");
			resp.getWriter().write(html);
		} else
		{
			String msg = URLEncoder.encode("订单不是待支付状态", "UTF-8");
			String s = UrlConstant.PAYRESULT + "?msg=" + msg + "&redirect=" + UrlConstant.ORDERS;
			resp.sendRedirect(s);
		}

	}

	@RequestMapping(value = "wxpay", method = RequestMethod.GET)
	public void wxpay(@RequestParam(name = "order_id", required = true) String orderId,
			@RequestParam(name = "code", required = true) String code, HttpServletResponse resp,
			HttpServletRequest request) throws Exception
	{

		Order or = ordersService.getOrdersById(orderId);
		//判断order是否过期
		if (or.getStatus() == 1)
		{
			if (or.getLastPayTime().before(new Date()))
			{
				String msg = URLEncoder.encode("订单超时", "UTF-8");
				String s = UrlConstant.PAYRESULT + "?msg=" + msg + "&redirect=" + UrlConstant.ORDERS;
				resp.sendRedirect(s);
			}
			String token = wxPayService.genPayToken(code);

			JSONObject tokenJson = JSONObject.parseObject(token);
			String openid = tokenJson.getString("openid");
			String payParam = wxPayService.genPayData(or.getOrderNumber(), openid, or.getPrice(),
					request.getRemoteAddr());
			String s = "/html/orderpay/sendWxPay.html?" + payParam;
			//s = URLEncoder.encode(s, "UTF-8");
			resp.sendRedirect(s);
		} else
		{
			//订单不是待支付状态
			String msg = URLEncoder.encode("订单不是待支付状态", "UTF-8");
			String s = UrlConstant.PAYRESULT + "?msg=" + msg + "&redirect=" + UrlConstant.ORDERS;
			resp.sendRedirect(s);
		}

	}

	@RequestMapping(value = "wxPayBackendNotify", method = RequestMethod.POST)
	public void wxPayBackendNotify(HttpServletResponse resp, HttpServletRequest request)
	{
		request.getParameterValues("qqq");
	}

	@RequestMapping(value = "wxPayFrontendNotify", method = RequestMethod.GET)
	public void wxPayFrontendNotify(@RequestParam(value = "msg", required = true) String msg,
			@RequestParam(value = "orderNo", required = true) String orderNo, HttpServletResponse resp,
			HttpServletRequest request) throws Exception
	{
		logger.info("start to check Wx pay from front end with order number:{} and wxMsg:{}", orderNo, msg);
		if (msg.equalsIgnoreCase("get_brand_wcpay_request:ok") && wxPayService.isOrderPaid(orderNo))
		{
			//成功则更新订单状态
			Order or = ordersService.getOrdersByOrderNumber(orderNo);
			or.setStatus(OrderStatus.paid.getValue());
			or.setUserDisplayStatus(OrderStatusUserDisney.paid.getValue());
			or.setPayment(Payment.weixin.getValue());
			ordersService.saveOrder(or);
			logger.info(
					"end to check Wx pay from front end set order-{} status to {}, user display status to {}, payment to {}",
					orderNo, or.getStatus(), or.getUserDisplayStatus(), or.getPayment());
		}
		resp.sendRedirect(UrlConstant.ORDERS);
	}

	@RequestMapping(value = "unionpayFrontRec", method = RequestMethod.POST)
	public void unionpayFrontRec(HttpServletResponse resp, HttpServletRequest request) throws Exception
	{
		Map<String, String> respParam = getAllRequestParam(request);
		Map<String, String> valideData = null;
		String s = "";
		if (null != respParam && !respParam.isEmpty())
		{
			Iterator<Entry<String, String>> it = respParam.entrySet().iterator();
			valideData = new HashMap<String, String>(respParam.size());
			while (it.hasNext())
			{
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes(UnionPayConstant.encoding_UTF8), UnionPayConstant.encoding_UTF8);
				valideData.put(key, value);
			}
		}

		if (valideData.get("respCode").equals("00") && AcpService.validate(valideData, UnionPayConstant.encoding_UTF8))
		{
			s = UrlConstant.PAYRESULT + "?msg=支付成功&redirect=" + UrlConstant.ORDERS;
			Order or = ordersService.getOrdersById(valideData.get("orderId"));
			or.setStatus(OrderStatus.paid.getValue());
			or.setUserDisplayStatus(OrderStatusUserDisney.paid.getValue());
			or.setPayment(Payment.zhifubao.getValue());
			ordersService.saveOrder(or);

		} else
		{
			s = UrlConstant.PAYRESULT + "?msg=付款异常，如您在银联已付款将被退回&redirect=" + UrlConstant.ORDERS;
			System.out.println(valideData.get("orderId")); //其他字段也可用类似方式获取
		}

		//无论成功失败，新增此次交易记录
		unionPayService.saveUnionpayRes(initUnionpayRes(valideData));
		s = URLEncoder.encode(s, "UTF-8");
		resp.sendRedirect(s);

	}

	public static Map<String, String> getAllRequestParam(final HttpServletRequest request)
	{
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp)
		{
			while (temp.hasMoreElements())
			{
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (res.get(en) == null || "".equals(res.get(en)))
				{
					// System.out.println("======为空的字段名===="+en);
					res.remove(en);
				}
			}
		}
		return res;
	}

	public static UnionpayRes initUnionpayRes(Map<String, String> valideData)
	{
		UnionpayRes uRes = new UnionpayRes();
		uRes.setAccNo(valideData.get("accNo"));
		uRes.setCertId(valideData.get("certId"));
		uRes.setOrderId(valideData.get("orderId"));
		uRes.setQueryId(valideData.get("queryId"));
		uRes.setRespCode(valideData.get("respCode"));
		uRes.setRespMsg(valideData.get("respMsg"));
		uRes.setSettleCurrencyCode(valideData.get("settleCurrencyCode"));
		uRes.setSettleDate(valideData.get("settleDate"));
		uRes.setTraceNo(valideData.get("traceNo"));
		uRes.setTxnSubType(valideData.get("txnSubType"));
		uRes.setTxnType(valideData.get("txnType"));
		uRes.setTxnTime(valideData.get("txnTime"));
		return uRes;
	}

}
