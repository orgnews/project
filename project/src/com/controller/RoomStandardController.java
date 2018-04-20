package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.RoomStandard;
import com.service.RoomStandardService;

@Controller
public class RoomStandardController {

	@Autowired
	private RoomStandardService roomStandardService;
	
	@RequestMapping(value="/roomStandard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addRoomStandard(RoomStandard roomStandard){
		Map<String,Object> map = new HashMap<String,Object>();
		roomStandardService.addRoomStandard(roomStandard);
		map.put("success", "成功");
		return map;
	}
	@RequestMapping(value="/room",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("age", "22");
		map.put("name", "祝明");
		map.put("sex", "南");
		return map;
	}
}
