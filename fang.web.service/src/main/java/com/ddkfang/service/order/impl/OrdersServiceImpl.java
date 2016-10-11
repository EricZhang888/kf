package com.ddkfang.service.order.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.order.Order;
import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;
import com.ddkfang.dao.repositories.order.OrderRepo;
import com.ddkfang.dao.repositories.room.RoomPriceRepo;
import com.ddkfang.exception.OrderDateConflictException;
import com.ddkfang.service.order.IOrdersService;
import com.ddkfang.util.priceCalendar.PriceCalendarUtil;
@Service
public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RoomPriceRepo roomPriceRepo;
	
	/**
	 * return new order Id
	 */
	public String createOrder(Map<String, Object> infoMap) throws Exception {
		
		String id = infoMap.get("roomId").toString();
		String beginDate = infoMap.get("checkInDate").toString();
		String endDate = infoMap.get("checkOutDate").toString();
		
		//检查是否有日期不可用
		Iterable<RoomPriceCalendar> it = roomPriceRepo.findById_RoomIdAndId_RoomDateBetweenAndStatusNot(
				id, PriceCalendarUtil.stringToSimpleDate(beginDate),
				PriceCalendarUtil.stringToSimpleDate(endDate),
				0
				);
		List<RoomPriceCalendar> list = (List)it;
		if(list.size() > 0) {
			throw new OrderDateConflictException();
		}
		
		Order or = new Order();
		or.setRoomId(infoMap.get("roomId").toString());
		or.setDateStart(PriceCalendarUtil.stringToSimpleDate(infoMap.get("checkInDate").toString()));
		or.setDateEnd(PriceCalendarUtil.stringToSimpleDate(infoMap.get("checkOutDate").toString()));
		or.setBookerId(infoMap.get("bookerId").toString());
		or.setPrice((Integer)infoMap.get("price"));
		or.setTotalPrice((Integer)infoMap.get("basicPrice"));
		or.setCreateTime(PriceCalendarUtil.getCurrentTimestamp());
		or.setUpdateTime(PriceCalendarUtil.getCurrentTimestamp());
		//新建订单 默认为代付款
		or.setStatus(1);
		or.setChannel((Integer)infoMap.get("channel"));
		orderRepo.save(or);
		
		//更新或插入价格日历
		return or.getId();
	}

}
