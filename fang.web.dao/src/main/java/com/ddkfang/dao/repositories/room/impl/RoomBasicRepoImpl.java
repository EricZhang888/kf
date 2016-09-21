package com.ddkfang.dao.repositories.room.impl;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.base.AbstractSearchableJpaRepository;

public class RoomBasicRepoImpl extends AbstractSearchableJpaRepository<Room>{

	public Iterable<Room> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Room> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Room arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Room> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Serializable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Room> findAll(Iterable<Serializable> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Room findOne(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Room> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Room> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
