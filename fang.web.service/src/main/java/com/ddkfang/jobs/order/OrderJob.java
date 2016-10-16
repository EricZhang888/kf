package com.ddkfang.jobs.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ddkfang.service.order.IOrdersService;

@Component
public class OrderJob {

	@Autowired
	IOrdersService ordersService;
	
	@Scheduled(cron="0 0/5 * * * ? ")
	public void updateExpiredOrder(){
		try {
			System.out.println("进入过期订单处理");
			ordersService.updateExpiredOrdersCalendar();
			System.out.println("结束过期订单处理");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
