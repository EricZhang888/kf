package com.ddkfang.dao.repositories.room;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ddkfang.dao.entity.rooms.Room;

public interface IRoomBasicRepo extends PagingAndSortingRepository<Room, Serializable>{

	public Page<Room> findByRoomCity(String city, Pageable pageable);
}
