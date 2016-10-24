package com.bohosi.yhf.dao.repositories.room;

import java.io.Serializable;

import com.bohosi.yhf.dao.entity.rooms.Room;
import com.bohosi.yhf.dao.repositories.base.IBaseRepo;

public interface RoomBasicRepo extends IBaseRepo<Room, Serializable>
{
	public Room findOneByRoomId(String roomId);
}
