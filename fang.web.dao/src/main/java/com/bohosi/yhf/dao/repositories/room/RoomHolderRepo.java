package com.bohosi.yhf.dao.repositories.room;

import java.io.Serializable;

import javax.transaction.Transactional;

import com.bohosi.yhf.dao.entity.rooms.RoomHolder;
import com.bohosi.yhf.dao.repositories.base.IBaseRepo;

public interface RoomHolderRepo extends IBaseRepo<RoomHolder, Serializable>
{
	public RoomHolder findById(String id);
	
	@SuppressWarnings("unchecked")
	@Transactional
	public RoomHolder save(RoomHolder hr);
}
