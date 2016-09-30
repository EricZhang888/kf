package com.ddkfang.api.controller.room;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.dao.entity.rooms.Room;

@RestController
@RequestMapping("/api/room")
public class RoomController {

	
	@RequestMapping(value = "getAllAvaliableRooms", method = RequestMethod.GET)
	@ResponseBody
	public Room getRoomDetail(@RequestParam(value = "id", required = true) String id)
	{		
		
		return null;
	}
}
