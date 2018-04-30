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
	public Map<String,Object> queryRoomInFormation(int pageNum,int pageCount,String findCondition);
	public Map<String,Object> delRoomInFormation(String delId);
	public Map<String,Object> queryInFormationById(String id);
	public Map<String, Object> updateRoomInFormation(RoomInFormation roomInFormation);
	public Map<String,Object> residueRoomInformationStatus(int pageNum,int pageCount, String findCondition);
}
