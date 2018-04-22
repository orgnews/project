package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.RoomInFormation;

public interface RoomInformationMapper {

	public List<Object> queryRoomInformationStatus(@Param("room_status")String room_status);
	public List<Object> queryRoomInformationIn(@Param("number")int startPage,@Param("number")int number);
	public int queryRoomInformationInCount();
	public void updateRoomInformationStatus(@Param("room_status")String room_status,@Param("room_number")String room_number);

	public List<String> findRoom_number();

	public void addRoomInFormation(RoomInFormation roomInFormation);
}
