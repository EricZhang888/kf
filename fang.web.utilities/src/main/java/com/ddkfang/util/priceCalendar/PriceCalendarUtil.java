package com.ddkfang.util.priceCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class PriceCalendarUtil {

	private static int year = 0;
	private static int month = 0;
	private static int day = 0;
	private static int sumDay = 0;
	private static Calendar now;
	
	private static Set<String> calendarSet = new TreeSet<String>();

	/**
	 * 判断闰年函数
	 * 
	 * @param y
	 *            年
	 * @return 1 闰年
	 **/
	private static int isLeapYear(int y) {
		if ((y % 400 == 0) || (y % 100 != 0 && y % 4 == 0)) {
			return 1;
		} else
			return 0;
	}

	private static Calendar getInitCalendar() throws ParseException {

		Calendar now = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 设置日期的格式 now.setTime(DateFormat.parse(date)); return now;
		now.setTime(DateFormat.parse(DateFormat.format(new Date())));
		return now;
	}

	public static Set<String> genCalendar() throws ParseException {
		now = getInitCalendar();
		
		for(int i = 1; i <4; i++) {
			year = now.get(Calendar.YEAR);
			month = 1 + now.get(Calendar.MONTH);
			if(month > 12) {
				month -= 12;
				year =+ 1;
			}
			day = now.get(Calendar.DAY_OF_MONTH);
			now.set(year, month, 1);
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				sumDay = 31;
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				sumDay = 30;
			}
			if (month == 2) {
				if (isLeapYear(year) == 1) {
					sumDay = 29;
				} else {
					sumDay = 28;
				}
			}
			for (int j = 1; j <= sumDay; j++) {
				calendarSet.add(year + "-" + (month < 10 ? ("0" + month) : month) + "-" + (j<10 ? "0"+j : j) + "");
				//System.out.println(year + "-" + month + "-" + j + "");    
			}
		}
		return calendarSet;

		
	}
	public static void main(String[] args) throws ParseException {
		Set<String> calendar = genCalendar();
		for(String s : calendar) {
			
			System.out.println(s);
		}
		
		//System.out.println(year + "-" + month + "-" + day + "");
	}

}
