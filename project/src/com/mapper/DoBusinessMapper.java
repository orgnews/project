package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.DoBusiness;

public interface DoBusinessMapper {

	public void addDoBusiness(DoBusiness doBusiness);
	public List<Object> queryDoBusiness(@Param("startPage")int startPage,@Param("number")int number);
	public int queryDoBusinessCount();
}
