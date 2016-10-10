package com.ddkfang.dao.repositories.room;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;

public interface RoomPriceRepo extends CrudRepository<RoomPriceCalendar, Serializable> {

	public Iterable<RoomPriceCalendar> findById_RoomIdAndId_RoomDateBetween(String roomId, Date start, Date end);
	
	public Iterable<RoomPriceCalendar> findById_RoomIdAndId_RoomDateBetweenAndStatusNot(String roomId, Date start, Date end, int status);
}
