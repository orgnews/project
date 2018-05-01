package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.DoBusinessMapper;
import com.mapper.ReceptionMapper;
import com.mapper.RoomInformationMapper;
import com.mapper.RoomStandardMapper;
import com.pojo.DoBusiness;
import com.pojo.Paging;
import com.pojo.Reception;
import com.pojo.RoomStandard;
import com.service.ReceptionService;
import com.util.Util;

@Service
public class ReceptionServiceImpl implements ReceptionService {
	private final static Map<String,Object> map = new HashMap<String,Object>();
	@Autowired
	private ReceptionMapper receptionMapper;
	@Resource
	private RoomStandardMapper roomStandardMapper;
	@Resource
	private RoomInformationMapper roomInformationMapper;
	@Resource
	private DoBusinessMapper doBusinessMapper;
	@Override
	public Map<String, Object> addReception(Reception reception) {
		map.clear();
		try {
			reception.setId(Util.uuid());
			receptionMapper.addReception(reception);
			roomInformationMapper.updateRoomInformationStatus("1", reception.getRoom_number());
			if(reception.getMoney_status().equals("1")){
				RoomStandard  roomStandard  = roomStandardMapper.queryRoomNumber(reception.getRoom_number());
				DoBusiness doBusiness = new DoBusiness();
				doBusiness.setId(Util.uuid());
				doBusiness.setMoney(roomStandard.getRoom_money());
				doBusiness.setRoom_number(reception.getRoom_number());
				doBusiness.setAdd_time(Util.date());
				doBusiness.setName(reception.getName());
				doBusiness.setId_card(reception.getId_card());
				doBusiness.setPhone(reception.getPhone());
				doBusinessMapper.addDoBusiness(doBusiness);
			}
			map.put("status", "200");
			map.put("message", "添加接待管理成功");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "添加接待管理失败");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteReception(String id) {
		map.clear();
		try {
			receptionMapper.deleteReception(id);
			map.put("status", "200");
			map.put("message", "删除接待管理成功");
		} catch (Exception e) {
			map.put("status", "200");
			map.put("message", "删除接待管理成功");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> updateReception(Reception reception) {
		map.clear();
		try {
			receptionMapper.updateReception(reception);
			map.put("status", "200");
			map.put("message", "删除接待管理成功");
		} catch (Exception e) {
			map.put("status", "200");
			map.put("message", "删除接待管理成功");
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryReception(int pageNum, int pageCount,String findCondition) {
		map.clear();
		try {
			int count = receptionMapper.queryReceptionCount(findCondition);
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = receptionMapper.queryReception(page.getStartCount(), pageCount,findCondition);
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
	public Map<String, Object> queryReceptionById(String id) {
		map.clear();
		try{
			Reception reception = receptionMapper.queryReceptionById(id);
			map.put("reception", reception);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

}
