package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

	public List<Object> queryLogin(@Param("username")String username,@Param("password")String password);
	public void addLogin(@Param("username")String username,@Param("password")String password);
	public List<Object> queryLoginAll(@Param("startPage")int startPage,@Param("number")int number);
	public int queryLoginCount();
	
	public void updateLogin(@Param("username")String username,@Param("password")String password);
	
	public void saveBlackStatus(@Param("username")String username,@Param("status")String status);
}
