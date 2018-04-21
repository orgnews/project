package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RoomStandardMapper;
import com.pojo.Paging;
import com.pojo.RoomStandard;
import com.service.RoomStandardService;
import com.util.Util;

@Service
public class RoomStandardServiceImpl implements RoomStandardService{

	@Autowired
	private RoomStandardMapper roomStandardMapper;
	@Override
	public Map<String,Object> addRoomStandard(RoomStandard roomStandard) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
		roomStandard.setId(Util.uuid());
		roomStandard.setEstablish_date(Util.date());
		// TODO Auto-generated method stub
		roomStandardMapper.addRoomStandard(roomStandard);
		map.put("status", 200);
		map.put("message", "新建客房信息成功");
		}catch(Exception e){
			map.put("status", 200);
			map.put("message", "新建客房信息失败");
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> queryRoomStandard(int pageNum, int pageCount,String findCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			int count = roomStandardMapper.queryRoomStandardCount(findCondition);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = roomStandardMapper.queryRoomStandard(page.getStartCount(), pageCount,findCondition);
			map.put("page", page);
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
	@Override
	public Map<String, Object> queryRoomStandardById(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			RoomStandard roomStandard = roomStandardMapper.queryRoomStandardById(id);
			map.put("roomStandard", roomStandard);
			map.put("status", "200");
			map.put("message", "查询客房信息成功");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询客房信息失败");
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> updateRoomStandard(RoomStandard roomStandard) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			roomStandardMapper.updateRoomStandard(roomStandard);
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
	public Map<String, Object> delRoomStandard(String delId) {
		Map<String,Object> map = new HashMap<String,Object>();

		try {
			roomStandardMapper.delRoomStandard(delId);
			map.put("status", "200");
			map.put("message", "删除客房信息成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "删除客房信息失败");
			e.printStackTrace();
		}
		
		return map;
	}

}
