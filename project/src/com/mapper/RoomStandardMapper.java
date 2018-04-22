package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.RoomStandard;

public interface RoomStandardMapper {

	public void addRoomStandard(RoomStandard roomStandard);
	
	public List<Object> queryRoomStandard(@Param("startPage")int startPage,@Param("number")int number,@Param("findCondition")String findCondition);
	public int queryRoomStandardCount(@Param("findCondition")String findCondition);
	
	public RoomStandard queryRoomStandardById(String id);
	public void updateRoomStandard(RoomStandard roomStandard);

	public void delRoomStandard(String delId);
	
	public RoomStandard queryRoomNumber(String room_number);
}
