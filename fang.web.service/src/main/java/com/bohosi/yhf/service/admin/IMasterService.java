package com.bohosi.yhf.service.admin;

import com.bohosi.yhf.dao.entity.admin.Master;

public interface IMasterService
{

	public Master getMasterByEmailOrMbile(String email);
	
}
