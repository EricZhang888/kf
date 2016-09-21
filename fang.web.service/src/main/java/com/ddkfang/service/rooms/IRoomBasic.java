package com.ddkfang.service.rooms;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.base.SearchCriteria;

public interface IRoomBasic {

	public List<Room> getActivityBanner();
	
	public Page<Room> getAllAvaliableRooms(SearchCriteria searchCriteria, Pageable pageable);

	public Room getRoomDetailById(String roomId);

	public void saveRoom(Room room);
}
