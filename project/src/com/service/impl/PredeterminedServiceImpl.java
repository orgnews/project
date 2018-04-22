package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.PredeterminedMapper;
import com.mapper.RoomInformationMapper;
import com.pojo.Paging;
import com.pojo.Predetermined;
import com.service.PredeterminedService;
import com.util.Util;

@Service
public class PredeterminedServiceImpl implements PredeterminedService {
	private final static Map<String, Object> map = new HashMap<String, Object>();

	@Resource
	private PredeterminedMapper predeterminedMapper;
	@Resource
	private RoomInformationMapper roomInformationMapper;

	@Override
	public Map<String, Object> addPredetermined(Predetermined predetermined) {
		map.clear();
		try {
			predeterminedMapper.addPredetermined(predetermined);
			roomInformationMapper.updateRoomInformationStatus("1", predetermined.getRoom_number());
			map.put("status", "200");
			map.put("message", "预订客房成功");
		} catch (Exception e) {
			map.put("status", "200");
			map.put("message", "预订客房失败");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> deletePredetermined(String id) {
		map.clear();
		try {
			predeterminedMapper.deletePredetermined(id);
			
			map.put("status", "200");
			map.put("message", "删除客房成功");
		} catch (Exception e) {
			map.put("status", "200");
			map.put("message", "删除客房成功");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> updatePredetermined(Predetermined predetermined) {
		map.clear();
		try {
			predeterminedMapper.updatePredetermined(predetermined);
			map.put("status", "200");
			map.put("message", "修改预定信息成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "修改预订信息失败");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryPredetermined(int pageNum, int pageCount) {
		map.clear();
		try {
			int count = predeterminedMapper.queryPredeterminedCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = predeterminedMapper.queryPredetermined(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e) {
			map.put("status", "200");
			map.put("message", "查询失败！");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryPredeterminedById(String id) {
		map.clear();
		try {
			Predetermined predetermined = predeterminedMapper.queryPredeterminedById(id);
			map.put("predetermined", predetermined);
			map.put("status", "200");
			map.put("message", "查询预定信息成功");
		} catch (Exception e) {
			map.put("status", "200");
			map.put("message", "查询预定信息失败");
			e.printStackTrace();
		}
		return map;
	}

}
