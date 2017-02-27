package com.bohosi.yhf.service.rooms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.rooms.RoomHolder;
import com.bohosi.yhf.dao.repositories.base.SearchCriteria;
import com.bohosi.yhf.dao.repositories.room.RoomHolderRepo;
import com.bohosi.yhf.service.rooms.IRoomHolder;

@Service
public class RoomHolderImpl implements IRoomHolder {

	@Autowired
	RoomHolderRepo roomHolderRepo;
	
	public Page<RoomHolder> getRoomHoldersByCriteria(SearchCriteria searchCriteria, Pageable pageable) {
		return roomHolderRepo.search(searchCriteria, pageable);
	}

}
