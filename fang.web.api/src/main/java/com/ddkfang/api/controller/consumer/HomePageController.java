package com.ddkfang.api.controller.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.dao.repositories.base.Criterion;
import com.ddkfang.dao.repositories.base.SearchCriteria;
import com.ddkfang.service.rooms.IRoomBasic;

@RestController
@RequestMapping("/api/home")
public class HomePageController
{

	@Autowired
	private IRoomBasic roomBasic;

	/**
	 * ��ݼ���������ѯ��ϵķ�Դ
	 * 
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value = "getAllAvaliableRooms", method = RequestMethod.GET)
	@ResponseBody
	public Page<Room> getAllAvaliableRooms(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "site", required = false) String site, //所属景点名
			@RequestParam(value = "checkInDate", required = false) String checkInDate,
			@RequestParam(value = "checkOutDate", required = false) String checkOutDate, Pageable pageable)
	{

		SearchCriteria criteria = SearchCriteria.Builder.create();
		if (!StringUtils.isEmpty(city))
		{
			criteria.add(new Criterion("roomCityName", Criterion.Operator.EQ, city));
		}
		if (!StringUtils.isEmpty(site))
		{
			criteria.add(new Criterion("roomApartment_apartmentName", Criterion.Operator.EQ, site));
		}
		if (!StringUtils.isEmpty(checkInDate))
		{
			criteria.add(new Criterion("roomSite", Criterion.Operator.EQ, checkInDate));
		}
		if (!StringUtils.isEmpty(checkOutDate))
		{
			criteria.add(new Criterion("roomSite", Criterion.Operator.EQ, checkOutDate));
		}
		return roomBasic.getAllAvaliableRooms(criteria, pageable);
	}

	/**
	 * ��ȡ��ҳ�ֲ��Ƽ���Դ
	 * 
	 * @return
	 */
	@RequestMapping(value = "getActivityBanner", method = RequestMethod.POST)
	@ResponseBody
	public List<Room> getActivityBanner()
	{
		return roomBasic.getActivityBanner();
	}

	/**
	 * ���room id ��÷�������
	 * 
	 * @param roomId
	 * @return
	 */
	@RequestMapping(value = "getRoomDetailById", method = RequestMethod.GET)
	@ResponseBody
	public Room getRecRooms(@RequestParam String roomId)
	{
		Room r = roomBasic.getRoomDetailById(roomId);
		return r;
	}
}
