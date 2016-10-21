package com.ddkfang.dao.repositories.room;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.LockModeType;

import org.hibernate.LockMode;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import com.ddkfang.dao.entity.rooms.RoomPriceCalendar;

public interface RoomPriceRepo extends CrudRepository<RoomPriceCalendar, Serializable>
{

	public Iterable<RoomPriceCalendar> findById_RoomIdAndId_RoomDateBetween(String roomId, Date start, Date end);

	public RoomPriceCalendar findById_RoomIdAndId_RoomDate(String roomId, Date start);

	@Lock(value = LockModeType.PESSIMISTIC_WRITE)
	public RoomPriceCalendar save(RoomPriceCalendar rpc);

	public Iterable<RoomPriceCalendar> findById_RoomIdAndId_RoomDateBetweenAndStatusNot(String roomId, Date start,
			Date end, int status);
}
