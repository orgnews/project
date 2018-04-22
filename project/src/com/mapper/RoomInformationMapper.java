package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoomInformationMapper {

	public List<Object> queryRoomInformationStatus(@Param("room_status")String room_status);
	
	public void updateRoomInformationStatus(@Param("room_status")String room_status,@Param("room_number")String room_number);
}
