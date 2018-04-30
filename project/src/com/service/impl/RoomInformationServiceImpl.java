package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.RoomInformationMapper;
import com.pojo.Paging;
import com.pojo.RoomInFormation;
import com.pojo.RoomStandard;
import com.service.RoomInformationService;
import com.util.Util;

@Service
public class RoomInformationServiceImpl implements RoomInformationService {
	private final static Map<String,Object> map = new HashMap<String,Object>();
	@Resource
	private RoomInformationMapper roomInformationMapper;
	
	@Override
	public Map<String, Object> queryRoomInformationStatus(String room_status) {
		map.clear();
		try {
			List<Object> list = roomInformationMapper.queryRoomInformationStatus(room_status);
			map.put("list", list);
			map.put("status", "200");
			map.put("message", "查询信息成功");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询信息失败");
			e.printStackTrace();
		}
		return map;
	}
	//lxm剩余客房
	@Override
	public Map<String, Object> residueRoomInformationStatus(int pageNum,int pageCount, String findCondition) {
		map.clear();
		
		try {
			int count = roomInformationMapper.residueRoomStandardCount(findCondition);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList=roomInformationMapper.residueRoomInformationStatus(page.getStartCount(), pageCount,findCondition);
			map.put("page",page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询失败！");
			e.printStackTrace();
		}
		
		return map;
	}
	
	
	//查询所有房间号
	@Override
	public Map<String, Object> findRoom_number() {
		map.clear();
		List<String> list = roomInformationMapper.findRoom_number();
		map.put("list", list);
		return map;
	}
	//新增客房信息
	@Override
	public Map<String, Object> saveRoomInFormation(RoomInFormation roomInFormation) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
		roomInFormation.setId(Util.uuid());
		roomInFormation.setEstablish_date(Util.date());
		roomInFormation.setRoom_status("0");
		// TODO Auto-generated method stub
		roomInformationMapper.addRoomInFormation(roomInFormation);
		map.put("status", 200);
		map.put("message", "新建客房信息成功");
		}catch(Exception e){
			map.put("status", 200);
			map.put("message", "新建客房信息失败");
			e.printStackTrace();
		}
		return map;
	}
    //查询客房信息
	@Override
	public Map<String,Object>queryRoomInFormation(int pageNum,int pageCount,String findCondition){
		Map<String,Object>map=new HashMap<String, Object>();
		try {
			int count = roomInformationMapper.queryRoomStandardCount(findCondition);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList=roomInformationMapper.roomInformationMapper(page.getStartCount(), pageCount,findCondition);
			map.put("page",page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询失败！");
			e.printStackTrace();
		}
		return map;
	
	}
	//删除客房信息
	public Map<String,Object>delRoomInFormation(String delId){
		Map<String,Object>map=new HashMap<String, Object>();
		try {
			roomInformationMapper.delRoomInFormation(delId);
			map.put("status", "200");
			map.put("message", "删除客房信息成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "删除客房信息失败");
			e.printStackTrace();
		}
		
		return map;
		
	}
	//根据id查询
	@Override
	public Map<String, Object> queryInFormationById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			RoomInFormation roomInFormation = roomInformationMapper.queryInFormationById(id);
			map.put("roomInFormation", roomInFormation);
			map.put("status", "200");
			map.put("message", "查询客房信息成功");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询客房信息失败");
			e.printStackTrace();
		}
		return map;
	}
	//修改
	@Override
	public Map<String, Object> updateRoomInFormation(RoomInFormation roomInFormation) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			roomInformationMapper.updateRoomInFormation(roomInFormation);
			map.put("status", "200");
			map.put("message", "修改客房信息成功");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "修改客房信息失败");
			e.printStackTrace();
		}
		return map;
	}
	

	@Override
	public Map<String, Object> queryRoomInformationInStatus(int pageNum, int pageCount) {
		map.clear();
		try {
			int count = roomInformationMapper.queryRoomInformationInCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = roomInformationMapper.queryRoomInformationIn(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

}
