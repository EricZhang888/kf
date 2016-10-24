package com.bohosi.yhf.service.rooms.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.dao.repositories.room.RoomBasicRepo;
import com.bohosi.yhf.dao.repositories.room.RoomPriceRepo;
import com.bohosi.yhf.service.rooms.IRoomBasic;
import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;
@Service
public class RoomBasicImpl implements IRoomBasic
{

	@Autowired
	private RoomBasicRepo roomBasicRepo;

	@Autowired
	private RoomPriceRepo roomPriceRepo;

	public Room getRoomDetailById(String roomId)
	{
		Room room = roomBasicRepo.findOneByRoomId(roomId);
		return room;
	}

	public void saveRoom(Room room)
	{
		roomBasicRepo.save(room);
	}

	public List<Room> getActivityBanner()
	{
		return null;
	}

	public Page<Room> getAllAvaliableRooms(SearchCriteria searchCriteria, Pageable pageable)
	{
		return roomBasicRepo.search(searchCriteria, pageable);
	}

	public Map<String, RoomPriceCalendar> getRoomPriceCalendar(String roomId, String start, String end)
	{
		List<RoomPriceCalendar> pc = new ArrayList<RoomPriceCalendar>();
		Map<String, RoomPriceCalendar> map = new HashMap<String, RoomPriceCalendar>();
		try
		{
			pc = (ArrayList<RoomPriceCalendar>) roomPriceRepo.findById_RoomIdAndId_RoomDateBetween(roomId,
					PriceCalendarUtil.stringToSimpleDate(start), PriceCalendarUtil.stringToSimpleDate(end));
			if (pc != null && pc.size() > 0)
			{
				for (RoomPriceCalendar rpc : pc)
				{
					map.put(PriceCalendarUtil.simpleDateToString(rpc.getId().getRoomDate()), rpc);
				}
			}
			return map;
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pc.size());
		return null;
	}

}
