package com.bohosi.yhf.service.rooms.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendar;
import com.bohosi.yhf.dao.entity.rooms.RoomPriceCalendarPK;
import com.bohosi.yhf.dao.repositories.room.RoomPriceRepo;
import com.bohosi.yhf.service.rooms.IRoomPrice;
import com.bohosi.yhf.util.priceCalendar.PriceCalendarUtil;
@Service
public class RoomPriceImpl implements IRoomPrice
{

	private final static Logger logger = LoggerFactory.getLogger(RoomPriceImpl.class);
	
	@Autowired
	RoomPriceRepo roomPriceRepo;

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status, int price) throws Exception
	{
		RoomPriceCalendar rpc = roomPriceRepo.findById_RoomIdAndId_RoomDate(roomId, date);
		if (rpc != null)
		{
			logger.info("start update RoomPriceCalendar roomId:{} date:{} status from {} to {}", roomId, date, rpc.getStatus(), status);
			rpc.setStatus(status);
			rpc.setUpdateTime(PriceCalendarUtil.getCurrentTimestamp());
			roomPriceRepo.save(rpc);
		} else
		{
			RoomPriceCalendar rpcNew = new RoomPriceCalendar();
			RoomPriceCalendarPK pk = new RoomPriceCalendarPK();
			pk.setRoomDate(date);
			pk.setRoomId(roomId);
			rpcNew.setCreateBy("admin");
			rpcNew.setCreateTime(PriceCalendarUtil.getCurrentTimestamp());
			rpcNew.setStatus(status);
			rpcNew.setUpdateBy("admin");
			rpcNew.setUpdateTime(PriceCalendarUtil.getCurrentTimestamp());
			rpcNew.setRoomDatePrice(price);
			rpcNew.setId(pk);
			roomPriceRepo.save(rpcNew);
			logger.info("create new RoomPriceCalendar {}", rpcNew.toString());
		}
	}

	public void saveOrUpdatePriceCalendar(RoomPriceCalendar rpc)
	{
		// TODO Auto-generated method stub

	}

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status) throws Exception
	{
		saveOrUpdatePriceCalendar(roomId, date, status, 0);
	}

}
