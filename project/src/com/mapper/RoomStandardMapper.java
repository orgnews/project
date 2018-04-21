package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.RoomStandard;

public interface RoomStandardMapper {

	public void addRoomStandard(RoomStandard roomStandard);
	
	public List<Object> queryRoomStandard(@Param("startPage")int startPage,@Param("number")int number);
	public int queryRoomStandardCount();
}
