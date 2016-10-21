package com.ddkfang.api.controller.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.api.controller.BaseController;
@RestController
@RequestMapping("/api/commUtil")
public class CommonUtil extends BaseController
{

	@RequestMapping(value = "getUTC0SysTime", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getUTC0SysTime()
	{
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		sf.setTimeZone(TimeZone.getTimeZone("Greenwich"));
		String s = sf.format(d);
		Map<String, Object> time = new HashMap<String, Object>();
		time.put("now", s);
		return time; //"{\"now\": \"" + s +  "\" }";
	}

	public static void main(String[] args)
	{
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		sf.setTimeZone(TimeZone.getTimeZone("Greenwich"));
		String s = sf.format(d);
		System.out.println(s);
	}
}
