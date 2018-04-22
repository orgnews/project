package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.RoomInFormation;

public interface RoomInformationService {
	public Map<String,Object> queryRoomInformationStatus(String room_status);

	Map<String, Object> findRoom_number();

	public Map<String, Object> saveRoomInFormation(RoomInFormation roomInFormation);

	

	

	
}
