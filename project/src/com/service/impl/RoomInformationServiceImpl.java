package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.RoomInformationMapper;
import com.service.RoomInformationService;

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

}
