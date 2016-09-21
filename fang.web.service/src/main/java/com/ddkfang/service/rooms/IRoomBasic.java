package com.ddkfang.service.rooms;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ddkfang.dao.entity.rooms.Room;

public interface IRoomBasic {

	public List<Room> getActivityBanner();
	
	public Page<Room> getAllAvaliableRooms(String city, Pageable pageable);

	public Room getRoomDetailById(String roomId);

	public void saveRoom(Room room);
}
