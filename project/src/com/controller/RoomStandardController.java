package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		map = roomStandardService.addRoomStandard(roomStandard);
		return map;
	}
	/**
	 * 分页
	 * @param count	总共条数
	 * @param pageNum	第几页
	 * @param pageCount	每页的条数
	 * @return
	 */
	@RequestMapping(value="/roomStandard",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryRoomStandard(int pageNum,int pageCount, String findCondition){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomStandardService.queryRoomStandard(pageNum, pageCount,findCondition);
		return map;
	}
	
	@RequestMapping(value="/roomStandardById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryRoomStandardById(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomStandardService.queryRoomStandardById(id);
		return map;
	}
	
	
	@RequestMapping(value="/updateRoomStandard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateRoomStandard(RoomStandard roomStandard){
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomStandardService.updateRoomStandard(roomStandard);
		return map;
	}
	@RequestMapping(value="/delRoomStandard",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> delRoomStandard(String delId){
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomStandardService.delRoomStandard(delId);
		return map;
	}
	
	
}
