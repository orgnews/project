package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Reception;

public interface ReceptionMapper {

	public void addReception(Reception reception);
	
	public void deleteReception(@Param("id")String id);
	
	public List<Object> queryReception(@Param("startPage")int startPage,@Param("number")int number);
	
	public int queryReceptionCount();
	
	public Reception queryReceptionById(@Param("id")String id);
	
	public void updateReception(Reception reception);
}
