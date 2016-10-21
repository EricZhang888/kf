package com.yhf.dao.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class QueryTool
{

	public static Timestamp getCurrentTs()
	{
		Calendar calendar = Calendar.getInstance();
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		return time;
	}
}
