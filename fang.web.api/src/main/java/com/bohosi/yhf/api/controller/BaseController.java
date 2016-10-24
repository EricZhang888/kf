package com.bohosi.yhf.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController
{

	public ResponseEntity<Map<String, Object>> internalError()
	{

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("status", "500");
		responseMap.put("msg", "服务器内部异常");
		return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
