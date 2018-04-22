package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Predetermined;

public interface PredeterminedMapper {
	public void addPredetermined(Predetermined predetermined);
	public List<Object> queryPredetermined(@Param("startPage")int startPage,@Param("number")int number);
	public int queryPredeterminedCount();
	public Predetermined queryPredeterminedById(String id);
	public void updatePredetermined(Predetermined predetermined);
	public void deletePredetermined(String id);
}
