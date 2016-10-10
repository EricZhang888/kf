package com.ddkfang.api.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.api.bean.DayPrice;
import com.ddkfang.api.bean.TotalPrice;
import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;
import com.ddkfang.dao.entity.user.Booker;
import com.ddkfang.exception.OrderDateConflictException;
import com.ddkfang.exception.OrderPriceException;
import com.ddkfang.service.order.IOrdersService;
import com.ddkfang.service.rooms.IRoomBasic;
import com.ddkfang.util.priceCalendar.PriceCalendarUtil;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	IOrdersService ordersService;
	
	@Autowired
	IRoomBasic roomBasic;
	
	@RequestMapping(value="createOrder", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> createOrder(@RequestParam(value = "checkInDate", required = true) String checkInDate,
			@RequestParam(value = "checkOutDate", required = true) String checkOutDate,
			@RequestParam(value = "price", required = true) int price,
			@RequestParam(value = "contactName", required = true) String contactName,
			@RequestParam(value = "contactPhone", required = true) String contactPhone,
			@RequestParam(value = "roomId", required = true) String roomId,
			@RequestParam(value = "channel", required = true) int channel,
			HttpServletRequest request) throws Exception{
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			infoMap.put("roomId", roomId);
			infoMap.put("contactPhone", contactPhone);
			infoMap.put("contactName", contactName);
			infoMap.put("checkInDate", checkInDate);
			infoMap.put("checkOutDate",checkOutDate);
			infoMap.put("channel", channel);
			
			Booker bk = (Booker)request.getSession().getAttribute("user");
			infoMap.put("bookerId", bk.getId());
			
			//计算订单价格
			Room room = roomBasic.getRoomDetailById(roomId);
			//获取用户所选区间的已设置价格日历
			Map<String, RoomPriceCalendar> map = roomBasic.getRoomPriceCalendar(roomId, checkInDate, checkOutDate);
			int days = PriceCalendarUtil.dateDiff(checkOutDate, checkInDate);
			Set<String> cal = PriceCalendarUtil.genCalendarWithStr(checkInDate,days);
			List<DayPrice> dayDetailList = new ArrayList<DayPrice>();
			
			int totalPrice = 0;
			int totalBasicPrice = days * room.getRoomBasicPrice();
			
			TotalPrice tp = new TotalPrice();
			
			tp.setTotal_basic_price(totalBasicPrice);
			tp.setTotal_standard_price(totalBasicPrice);
			
			for(String s : cal) {
				DayPrice dp = new DayPrice();
				
				//通过日期匹配价格日历，如果没有匹配到 则使用Room默认价格
				RoomPriceCalendar rpc = map.get(s);
				dp.setDate(s);
				dp.setBasic_price(room.getRoomBasicPrice());
				
				if(rpc != null) {
					totalPrice += rpc.getRoomDatePrice().intValue();
					dp.setPreferential_price(rpc.getRoomDatePrice().intValue());
					dp.setStandard_price(rpc.getRoomDatePrice().intValue());
				} else {
					totalPrice += room.getRoomPrice();
					dp.setStandard_price(room.getRoomPrice());
					dp.setPreferential_price(room.getRoomBasicPrice());
				}
				dayDetailList.add(dp);
			}
			tp.setTotal_price(totalPrice);
			tp.setDay_price_list(dayDetailList);
			
			if(price != totalPrice) {
				throw new OrderPriceException();
			}
			infoMap.put("price", totalPrice);
			infoMap.put("basicPrice", totalBasicPrice);
			String createdOrderId = ordersService.createOrder(infoMap);
			responseMap.put("roomId", createdOrderId);
			responseMap.put("status", "A00000");
			responseMap.put("msg", "ok");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (OrderPriceException e) {
			responseMap.put("status", "A00001");
			responseMap.put("msg", "价格计算出现问题，请刷新重试！");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (OrderDateConflictException e) {
			responseMap.put("status", "A00002");
			responseMap.put("msg", "预定日期有冲突,手慢可能已被抢请刷新！");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			responseMap.put("status", "A00003");
			responseMap.put("msg", "系统错误");
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
