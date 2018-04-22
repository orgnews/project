package com.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoomInformationService {
	public Map<String,Object> queryRoomInformationStatus(String room_status);
	public Map<String,Object> queryRoomInformationInStatus(int pageNum, int pageCount);
}
