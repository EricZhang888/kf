package com.ddkfang.service.rooms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.base.SearchCriteria;
import com.ddkfang.dao.repositories.room.RoomBasicRepo;
import com.ddkfang.service.rooms.IRoomBasic;
@Service
public class RoomBasicImpl implements IRoomBasic {

	@Autowired
	private RoomBasicRepo roomBasicRepo;
	
	public Room getRoomDetailById(String roomId) {
		Room room = roomBasicRepo.findOne(roomId);
		return room;
	}

	public void saveRoom(Room room) {
		roomBasicRepo.save(room);
	}

	public List<Room> getActivityBanner() {
		return null;
	}

	public Page<Room> getAllAvaliableRooms(SearchCriteria searchCriteria, Pageable pageable) {
		return roomBasicRepo.search(searchCriteria, pageable);
	}
	
	

}
