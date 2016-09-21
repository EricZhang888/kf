package com.ddkfang.service.rooms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.room.IRoomBasicRepo;
import com.ddkfang.service.rooms.IRoomBasic;
@Service
public class RoomBasicImpl implements IRoomBasic {

	@Autowired
	private IRoomBasicRepo roomBasicRepo;
	
	public Room getRoomDetailById(String roomId) {
		Room room = roomBasicRepo.findOne(roomId);
		return room;
	}

	public void saveRoom(Room room) {
		roomBasicRepo.save(room);
	}

	public Page<Room> getAllAvaliableRooms(String city, Pageable pageable) {
		return roomBasicRepo.findByRoomCity(city, pageable);
	}

	public List<Room> getActivityBanner() {
		return null;
	}
	
	

}
