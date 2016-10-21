package com.ddkfang.service.orderpay.wx.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.ddkfang.constant.WxPayConstant;
import com.ddkfang.service.orderpay.wx.IWxPayService;
import com.ddkfang.util.verify.XMLParser;
import com.ddkfang.util.wxpay.WxPayUtil;
import com.tencent.wxpay.sdk.HttpUtil;
@Service
public class WxPayServiceImpl implements IWxPayService
{

	public String genPayData(String orderNo, String openid, int price, String ip) throws Exception
	{

		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("appid", WxPayConstant.appID);
		//paraMap.put("attach", "bohosi");  
		paraMap.put("body", "1号房");
		paraMap.put("mch_id", WxPayConstant.mchId);
		paraMap.put("nonce_str", WxPayUtil.createOnceStr());
		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", orderNo);
		paraMap.put("spbill_create_ip", ip);
		paraMap.put("total_fee", price);
		paraMap.put("trade_type", "JSAPI");
		paraMap.put("notify_url", "http://1hf.bohosi.com/api/order/pay/wxPayBackendNotify");// 此路径是微信服务器调用支付结果通知路径  
		String sign = WxPayUtil.getSign(paraMap);
		paraMap.put("sign", sign);
		String xml = WxPayUtil.mapToXml(paraMap);
		String xmlStr = HttpUtil.sendPostUrl(WxPayConstant.orderUrl, xml, "UTF-8");
		String prepayId = "";
		if (xmlStr.indexOf("SUCCESS") != -1)
		{
			Map<String, Object> map = XMLParser.getMapFromXML(xmlStr);
			prepayId = (String) map.get("prepay_id").toString();
		}

		Map<String, Object> payMap = new HashMap<String, Object>();
		payMap.put("appId", WxPayConstant.appID);
		String ts = WxPayUtil.createTimestamp();
		String nonc = WxPayUtil.createOnceStr();
		payMap.put("timeStamp", ts);
		payMap.put("nonceStr", nonc);
		payMap.put("signType", "MD5");
		payMap.put("package", "prepay_id=" + prepayId);
		String paySign = WxPayUtil.getSign(payMap);
		payMap.put("pg", prepayId);
		payMap.put("paySign", paySign);

		String payParam = "appId=" + WxPayConstant.appID + "&timeStamp=" + ts + "&nonceStr=" + nonc + "&signType=MD5"
				+ "&pg=" + prepayId + "&paySign=" + paySign + "&orderNo=" + orderNo;

		return payParam;
	}

	public String processWxPayResponse(String wxRes)
	{

		return null;
	}

	public String genPayToken(String code) throws Exception
	{
		String url = WxPayConstant.authUrl.replace("code=CODE", "code=" + code);
		String token = HttpUtil.sendPostUrl(url, "", "UTF-8");
		return token;
	}

	public boolean isOrderPaid(String orderNo)
	{
		try
		{
			Map<String, Object> map = XMLParser.getMapFromXML(queryOrder(orderNo));
			if(map.get("return_code").equals("SUCCESS")) {
				if(map.get("result_code").equals("SUCCESS")) {
					if(map.get("trade_state").equals("SUCCESS")) {
						return true;
					}
				}
			} else {
				return false;
			}
		} catch (ParserConfigurationException e)
		{
			return false;
		} catch (IOException e)
		{
			return false;
		} catch (SAXException e)
		{
			return false;
		} catch (Exception e)
		{
			return false;
		};
		return false;
	}
	
	
	private String queryOrder(String orderNo) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("appid", WxPayConstant.appID);
		paraMap.put("mch_id", WxPayConstant.mchId);
		paraMap.put("nonce_str", WxPayUtil.createOnceStr());
		paraMap.put("out_trade_no", orderNo);
		
		String sign = WxPayUtil.getSign(paraMap);
		paraMap.put("sign", sign);
		String xml = WxPayUtil.mapToXml(paraMap);
		String xmlStr = HttpUtil.sendPostUrl(WxPayConstant.orderQueryUrl, xml, "UTF-8");
		
		return xmlStr;
	}

}
