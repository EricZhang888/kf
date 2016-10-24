package com.bohosi.yhf.util.priceCalendar;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class PriceCalendarUtil
{

	private static int year = 0;

	private static int month = 0;

	private static int day = 0;

	private static int sumDay = 0;

	private static Calendar now;

	/**
	 * 判断闰年函数
	 * 
	 * @param y
	 *            年
	 * @return 1 闰年
	 **/
	private static int isLeapYear(int y)
	{
		if ((y % 400 == 0) || (y % 100 != 0 && y % 4 == 0))
		{
			return 1;
		} else
			return 0;
	}

	private static Calendar getInitCalendar() throws ParseException
	{

		Calendar now = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 设置日期的格式 now.setTime(DateFormat.parse(date)); return now;
		now.setTime(DateFormat.parse(DateFormat.format(new Date())));
		return now;
	}

	public static Set<String> genCalendar() throws ParseException
	{
		Set<String> calendarSet = new TreeSet<String>();
		now = getInitCalendar();

		for (int i = 1; i < 4; i++)
		{
			year = now.get(Calendar.YEAR);
			month = 1 + now.get(Calendar.MONTH);
			if (month > 12)
			{
				month -= 12;
				year = +1;
			}
			day = now.get(Calendar.DAY_OF_MONTH);
			now.set(year, month, 1);
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				sumDay = 31;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11)
			{
				sumDay = 30;
			}
			if (month == 2)
			{
				if (isLeapYear(year) == 1)
				{
					sumDay = 29;
				} else
				{
					sumDay = 28;
				}
			}
			for (int j = 1; j <= sumDay; j++)
			{
				calendarSet.add(year + "-" + (month < 10 ? ("0" + month) : month) + "-" + (j < 10 ? "0" + j : j) + "");
				//System.out.println(year + "-" + month + "-" + j + "");    
			}
		}
		return calendarSet;

	}

	public static Set<String> genCalendarWithStr(String startDate, int days) throws ParseException
	{

		Set<String> calendarWiehDaysSet = new TreeSet<String>();
		int year = 0;
		int month = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(startDate);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		for (int i = 0; i < days; i++)
		{
			now.add(Calendar.DAY_OF_MONTH, i == 0 ? 0 : 1);
			year = now.get(Calendar.YEAR);
			month = 1 + now.get(Calendar.MONTH);
			int day = now.get(Calendar.DAY_OF_MONTH);
			if (month > 12)
			{
				month -= 12;
				year = +1;
			}
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				sumDay = 31;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11)
			{
				sumDay = 30;
			}
			if (month == 2)
			{
				if (isLeapYear(year) == 1)
				{
					sumDay = 29;
				} else
				{
					sumDay = 28;
				}
			}
			calendarWiehDaysSet
					.add(year + "-" + (month < 10 ? ("0" + month) : month) + "-" + (day < 10 ? "0" + day : day) + "");
			//System.out.println(year + "-" + month + "-" + j + "");    
		}
		return calendarWiehDaysSet;
	}

	public static Date stringToSimpleDate(String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return sdf.parse(dateStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return sdf.parse("2000-01-01");
		}
	}

	public static int dateDiff(String sd1, String sd2) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(sd1);
		Date d2 = sdf.parse(sd2);

		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		int dayDiff = (int) (c1.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		return dayDiff;
	}

	public static int dateDiff(Date sd1, Date sd2) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(sd1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(sd2);
		int dayDiff = (int) (c1.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		return dayDiff;
	}

	public static String simpleDateToString(Date date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static Timestamp getCurrentTimestamp()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		return time;
	}

	public static Timestamp getExactTimestamp(int field, int amount)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(field, amount);
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		return time;
	}

	public static String getUniqueTimestampStr()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	public static void main(String[] args) throws ParseException
	{
		System.out.println(getUniqueTimestampStr());
	}

}
