package com.bohosi.yhf.api.jobs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bohosi.yhf.service.order.IOrdersService;

@Component
public class OrderJob
{

	@Autowired
	IOrdersService ordersService;

	@Scheduled(cron = "0 0/5 * * * ? ")
	public void updateExpiredOrder()
	{
		try
		{
			System.out.println(new Date().toString() + "start overtime order handling");
			ordersService.updateExpiredOrdersCalendar();
			System.out.println(new Date().toString() + "finish overtime order handling");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Scheduled(cron = "0 1 0 * * ? ")
	public void updateNoCheckInOrder()
	{
		try
		{
			System.out.println(new Date().toString() + "start no check in order handling");
			ordersService.updateNoCheckInOrdersCalendar();
			System.out.println(new Date().toString() + "finish no check in order handling");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
