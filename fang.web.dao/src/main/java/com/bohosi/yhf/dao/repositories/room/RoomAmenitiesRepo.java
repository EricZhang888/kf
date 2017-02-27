package com.bohosi.yhf.dao.repositories.room;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.bohosi.yhf.dao.entity.rooms.RoomAmenity;
import com.bohosi.yhf.dao.repositories.base.IBaseRepo;

public interface RoomAmenitiesRepo extends CrudRepository<RoomAmenity, Serializable>
{
	
}

