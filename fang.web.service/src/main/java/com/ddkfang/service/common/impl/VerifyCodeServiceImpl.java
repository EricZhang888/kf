package com.ddkfang.service.common.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ddkfang.dao.entity.common.VerifyCode;
import com.ddkfang.dao.entity.order.Order;
import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.common.VerifyCodeRepo;
import com.ddkfang.dao.repositories.order.OrderRepo;
import com.ddkfang.dao.repositories.room.RoomBasicRepo;
import com.ddkfang.service.common.IVerifyCodeService;
import com.ddkfang.util.verify.SmsTypeEnum;
import com.ddkfang.util.verify.VerifyCodeUtil;
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService
{

	@Autowired
	VerifyCodeRepo verifyCodeRepo;

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	RoomBasicRepo roomBasicRepo;

	public void insertNewCode(VerifyCode code)
	{
		verifyCodeRepo.save(code);
	}

	public String findLatestCodeByPhone(String phone)
	{

		VerifyCode code = verifyCodeRepo.findTop1ByPhoneOrderByCreateTimeDesc(phone);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -5);
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		//验证码5分钟有效期
		if (code != null && time.before(code.getCreateTime()))
		{
			return code.getCode();
		}
		return "";
	}

	
	public void sendOrderSmsNotice(String orderNo)
	{
		try
		{
			Order or = orderRepo.findByOrderNumber(orderNo);
			Room room = roomBasicRepo.findOneByRoomId(or.getRoomId());
			String roomInfo = or.getApartmentName() + room.getRoomBuilding() + room.getRoomFloor() + "层"
					+ room.getRoomNumber() + " " + or.getDateStart() + "入住-" + or.getDateEnd() + "退房";
			VerifyCodeUtil.sendRoomPaid("13761170304", roomInfo,
					SmsTypeEnum.roomPaidAdmin.getTempName());
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		//Timestamp t1 = new Timestamp(new Date())
	}
}
