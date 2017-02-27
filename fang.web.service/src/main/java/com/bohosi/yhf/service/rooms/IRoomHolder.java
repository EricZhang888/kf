package com.bohosi.yhf.service.rooms;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bohosi.yhf.dao.entity.rooms.RoomHolder;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;

public interface IRoomHolder
{
	public Page<RoomHolder> getRoomHoldersByCriteria (SearchCriteria searchCriteria, Pageable pageable);
	
	public RoomHolder saveRoomHolder (RoomHolder rh);
	
	public RoomHolder getRoomHolderById (String id);
}
