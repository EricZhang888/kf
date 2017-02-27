package com.bohosi.yhf.dao.repositories.room.impl;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.bohosi.yhf.dao.entity.rooms.RoomHolder;
import com.bohosi.yhf.dao.repositories.base.AbstractSearchableJpaRepository;

public class RoomHolderRepoImpl extends AbstractSearchableJpaRepository<RoomHolder> {

	public Iterable<RoomHolder> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<RoomHolder> findAll(Pageable arg0) {
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

	public void delete(RoomHolder arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends RoomHolder> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Serializable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<RoomHolder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<RoomHolder> findAll(Iterable<Serializable> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoomHolder findOne(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends RoomHolder> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends RoomHolder> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
