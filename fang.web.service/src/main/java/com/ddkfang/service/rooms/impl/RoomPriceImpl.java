package com.ddkfang.service.rooms.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;
import com.ddkfang.dao.entity.rooms.RoomPriceCalendarPK;
import com.ddkfang.dao.repositories.room.RoomPriceRepo;
import com.ddkfang.service.rooms.IRoomPrice;
import com.ddkfang.util.priceCalendar.PriceCalendarUtil;
@Service
public class RoomPriceImpl implements IRoomPrice {

	@Autowired
	RoomPriceRepo roomPriceRepo;
	
	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status, int price) {
		RoomPriceCalendar rpc = roomPriceRepo.findById_RoomIdAndId_RoomDate(roomId, date);
		if(rpc != null) {
			rpc.setStatus(status);
			rpc.setUpdateTime(PriceCalendarUtil.getCurrentTimestamp());
			roomPriceRepo.save(rpc);
		} else {
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
		}
	}

	public void saveOrUpdatePriceCalendar(RoomPriceCalendar rpc) {
		// TODO Auto-generated method stub

	}

	public void saveOrUpdatePriceCalendar(String roomId, Date date, int status) {
		saveOrUpdatePriceCalendar(roomId, date, status, 0);
	}

}
