package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.RoomInformationMapper;
import com.pojo.Paging;
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
