package com.bohosi.yhf.service.rooms.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.rooms.PriceCalendar;
import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.entity.rooms.RoomAmenity;
import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.dao.repositories.room.RoomAmenitiesRepo;
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
	
	@Autowired
	private RoomAmenitiesRepo roomAmenitiesRepo;

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

	public List<PriceCalendar> fullfillRoomPriceCalendar(Room room, Set<String> cal, Map<String, RoomPriceCalendar> map) {
		List<PriceCalendar> calList = new ArrayList<PriceCalendar>();
		for (String s : cal)
		{
			PriceCalendar pc = new PriceCalendar();
			//通过日期匹配价格日历，如果没有匹配到 则使用Room默认价格
			RoomPriceCalendar rpc = map.get(s);
			pc.setDate(s);
			if (rpc != null)
			{
				pc.setIs_full_booked(rpc.getStatus() == 0 ? 0 : 1);
				pc.setPrice(rpc.getRoomDatePrice());
				pc.setIs_preferential_price(0);
			} else
			{
				pc.setIs_full_booked(0);
				pc.setPrice(room.getRoomPrice());
				pc.setIs_preferential_price(0);
			}
			calList.add(pc);
		}
		
		return calList;
	}

	public List<RoomPriceCalendar> findUnavailableRoomIdByDate(Date start, Date end, int status)
	{
		return (List<RoomPriceCalendar>) roomPriceRepo.findUnavailableRoomIdByDate(start, end, status);
	}

	public Map<String, Object> getAllAvaliableRooms(SearchCriteria searchCriteria, Pageable pageable, String status)
	{
		return roomBasicRepo.search(searchCriteria, pageable, status);
	}

	public List<RoomAmenity> getAllAmenity() {
		return (List<RoomAmenity>) roomAmenitiesRepo.findAll();
	}
}
