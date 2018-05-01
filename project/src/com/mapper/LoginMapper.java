package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

	public List<Object> queryLogin(@Param("username")String username,@Param("password")String password);
}
