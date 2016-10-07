package com.ddkfang.api.controller.room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddkfang.api.bean.PriceCalendar;
import com.ddkfang.constant.HttpStatusConstant;
import com.ddkfang.dao.entity.rooms.Room;
import com.ddkfang.service.rooms.IRoomBasic;
import com.ddkfang.util.priceCalendar.PriceCalendarUtil;

@RestController
@RequestMapping("/api/room")
public class RoomController {

	@Autowired
	IRoomBasic roomBasic;
	
	@RequestMapping(value = "getRoomDetail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getRoomDetail(@RequestParam(value = "id", required = true) String id,HttpServletRequest request)
	{	
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
		
			Room room = roomBasic.getRoomDetailById(id);
			if(room != null) {
				responseMap.put("data", room);
				responseMap.put("status", HttpStatusConstant.roomStatus.ok.getCode());
				responseMap.put("msg", HttpStatusConstant.roomStatus.ok.getMsg());
				
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			} else {
				responseMap.put("data", null);
				responseMap.put("status", HttpStatusConstant.roomStatus.roomNotExist.getCode());
				responseMap.put("msg", HttpStatusConstant.roomStatus.roomNotExist.getMsg());
				return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
			}
		} catch(Exception e){
			e.printStackTrace();
			responseMap.put("data", null);
			responseMap.put("status", HttpStatusConstant.roomStatus.roomNotAvalibale.getCode());
			responseMap.put("msg", HttpStatusConstant.roomStatus.roomNotAvalibale.getMsg());
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@RequestMapping(value = "getPriceCalendar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getPriceCalendar(@RequestParam(value = "id", required = true) String id, HttpServletRequest request) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			Set<String> cal = PriceCalendarUtil.genCalendar();
			List<PriceCalendar> calList = new ArrayList<PriceCalendar>();
			for(String s : cal) {
				PriceCalendar pc = new PriceCalendar();
				pc.setDate(s);
				pc.setIs_full_booked(0);
				pc.setPrice(333);
				pc.setIs_preferential_price(0);
				calList.add(pc);
			}
			
			responseMap.put("data", calList);
			responseMap.put("status", HttpStatusConstant.roomStatus.ok.getCode());
			responseMap.put("msg", HttpStatusConstant.roomStatus.ok.getMsg());
			
			return new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.OK);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
