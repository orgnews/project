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
	public Map<String, Object> queryRoomStandard(int pageNum, int pageCount) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			int count = roomStandardMapper.queryRoomStandardCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = roomStandardMapper.queryRoomStandard(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e) {
			map.put("status", "500");
			map.put("message", "查询失败！");
			e.printStackTrace();
		}
		/*int count = englishWordMapper.countEnglish(startTime,endTime,englishWord);
		Paging page = Util.paging(count, pageNum, pageCount);
		List<Object> objList = englishWordMapper.queryAllEnglishWord(page.getStartCount(), pageCount,startTime,endTime,englishWord);
		map.put("page", page);
		map.put("list", objList);
		map.put("status", "200");
		map.put("message", "查询英语成功！");*/
		return map;
	}

}
