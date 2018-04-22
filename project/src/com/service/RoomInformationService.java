package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.pojo.RoomInFormation;

public interface RoomInformationService {
	public Map<String,Object> queryRoomInformationStatus(String room_status);
	public Map<String,Object> queryRoomInformationInStatus(int pageNum, int pageCount);

	Map<String, Object> findRoom_number();

	public Map<String, Object> saveRoomInFormation(RoomInFormation roomInFormation);

	
	

	
}
