package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.RoomInFormation;
import com.pojo.RoomStandard;

public interface RoomInformationMapper {

	public List<Object> queryRoomInformationStatus(@Param("room_status")String room_status);
	public List<Object> residueRoomInformationStatus(@Param("startPage")int startPage,@Param("number")int number,@Param("findCondition")String findCondition);
	public List<Object> queryRoomInformationIn(@Param("number")int startPage,@Param("number")int number);
	public int queryRoomInformationInCount();
	
	public void updateRoomInformationStatus(@Param("room_status")String room_status,@Param("room_number")String room_number);

	public List<String> findRoom_number();

	public void addRoomInFormation(RoomInFormation roomInFormation);
	public int queryRoomStandardCount(@Param("findCondition")String findCondition);
	public int residueRoomStandardCount(@Param("findCondition")String findCondition);
	
	public List<Object> roomInformationMapper(@Param("startPage")int startPage,@Param("number")int number,@Param("findCondition")String findCondition);
	public void delRoomInFormation(String delId);
	public RoomInFormation queryInFormationById(String id);
	public void updateRoomInFormation(RoomInFormation roomInFormation);
	

}
