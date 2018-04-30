package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.RoomInFormation;
import com.pojo.RoomStandard;
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
	
	@RequestMapping(value="/inStatus",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryRoomInformationInStatus(int pageNum, int pageCount){
		map.clear();
		map = roomInformationService.queryRoomInformationInStatus(pageNum,pageCount);
		return map;
	}
	//查询所有房间号
	@RequestMapping(value="/findRoom_number",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findRoom_number(){
		map.clear();
		map = roomInformationService.findRoom_number();
         return map;
		}
	//添加客房信息saveRoomStandrd
	@RequestMapping(value="/saveRoomInFormation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> saveRoomInFormation(RoomInFormation roomInFormation){
		map.clear();
		map = roomInformationService.saveRoomInFormation(roomInFormation);
        return map;
	}
	//lxm 查询客房
	@RequestMapping(value="/roomInFormation",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object>queryRoomInFormation(int pageNum,int pageCount, String findCondition){
		Map<String,Object>map=new HashMap<String, Object>();
		map=roomInformationService.queryRoomInFormation(pageNum, pageCount,findCondition);
		return map;
	}
	//lxm删除客房
	@RequestMapping(value="/delRoomInFormationById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> delRoomInFormation(String delId){
		Map<String,Object>map=new HashMap<String, Object>();
		map=roomInformationService.delRoomInFormation(delId);
		return map;
		
	}
	//lxm通过id获取客房信息
	@RequestMapping(value="/roomInFormationById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryInFormationById(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomInformationService.queryInFormationById(id);
		return map;
	}
	//lxm修改客房信息
	@RequestMapping(value="/updateRoomInFormation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateRoomInFormation(RoomInFormation roomInFormation){
		Map<String,Object> map = new HashMap<String,Object>();
		map = roomInformationService.updateRoomInFormation(roomInFormation);
		return map;
	}
	
	//lxm剩余客房
	@RequestMapping(value="/residueRoomStandard",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> residueRoomInformationStatus(int pageNum,int pageCount, String findCondition){
		map.clear();
		map = roomInformationService.residueRoomInformationStatus(pageNum, pageCount,findCondition);
		return map;
	}
	
}
