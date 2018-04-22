package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.RoomInformationService;

@Controller
public class RoomInformationController {
	private static Map<String,Object> map = new HashMap<String,Object>();
	@Resource
	private RoomInformationService roomInformationService;
	
	
	@RequestMapping(value="/status",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryRoomInformationStatus(String room_status){
		map.clear();
		map = roomInformationService.queryRoomInformationStatus(room_status);
		return map;
	}
}
