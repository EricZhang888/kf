package com.ddkfang.api.controller.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.service.rooms.IRoomBasic;

@RestController
@RequestMapping("/home")
public class HomePageController {

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
			@RequestParam(value = "checkInDate", required = false) String checkInDate, 
			@RequestParam(value = "checkOutDate", required = false) String checkOutDate,
			Pageable pageable) {
		return roomBasic.getAllAvaliableRooms(city, pageable);
	}

	/**
	 * ��ȡ��ҳ�ֲ��Ƽ���Դ
	 * 
	 * @return
	 */
	@RequestMapping(value = "getActivityBanner", method = RequestMethod.POST)
	@ResponseBody
	public List<Room> getActivityBanner() {
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
	public Room getRecRooms(@RequestParam String roomId) {
		Room r = roomBasic.getRoomDetailById(roomId);
		return r;
	}

	/**
	 * �������޸�һ��������Ϣ
	 * 
	 * @param roomName
	 * @param roomCity
	 * @param roomAddress
	 */
	@RequestMapping(value = "saveRoom", method = RequestMethod.GET)
	@ResponseBody
	public void saveRoom(@RequestParam String roomName, @RequestParam String roomCity,
			@RequestParam String roomAddress) {
		Room r = new Room();
		r.setRoomAddress(roomAddress);
		r.setRoomCity(roomCity);
		r.setRoomName(roomName);
		roomBasic.saveRoom(r);
	}
}
