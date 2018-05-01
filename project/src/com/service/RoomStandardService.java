package com.service;

import java.util.Map;

import com.pojo.RoomStandard;

public interface RoomStandardService {

	public Map<String,Object> addRoomStandard(RoomStandard roomStandard);
	
	public Map<String,Object> queryRoomStandard(int pageNum,int pageCount,String findCondition);
	
	public Map<String,Object> queryRoomStandardById(String id);
	
	public Map<String,Object> updateRoomStandard(RoomStandard roomStandard);

	public Map<String, Object> delRoomStandard(String delId);

	public Map<String, Object> queryEarlyWarningRoomStandard(String id);
}
