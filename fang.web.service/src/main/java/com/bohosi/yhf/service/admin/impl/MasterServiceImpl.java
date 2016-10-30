package com.bohosi.yhf.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bohosi.yhf.dao.entity.admin.Master;
import com.bohosi.yhf.dao.repositories.admin.MasterRepo;
import com.bohosi.yhf.service.admin.IMasterService;
@Service
public class MasterServiceImpl implements IMasterService
{

	@Autowired
	MasterRepo masterRepo;
	
	public Master getMasterByEmailOrMbile(String str)
	{
		return masterRepo.findByMobileOrEmail(str, str);
	}
}
