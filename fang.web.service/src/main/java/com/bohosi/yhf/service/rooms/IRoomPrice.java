package com.bohosi.yhf.service.rooms;

import java.util.Date;

import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;

public interface IRoomPrice
{

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status, int price) throws Exception;

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status) throws Exception;

	public void saveOrUpdatePriceCalendar(RoomPriceCalendar rpc);
}
