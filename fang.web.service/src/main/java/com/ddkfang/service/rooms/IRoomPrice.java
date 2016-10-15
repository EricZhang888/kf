package com.ddkfang.service.rooms;

import java.util.Date;

import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;

public interface IRoomPrice {

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status, int price);
	
	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status);
	
	public void saveOrUpdatePriceCalendar(RoomPriceCalendar rpc);
}
