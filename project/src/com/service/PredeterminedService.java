package com.service;

import java.util.Map;

import com.pojo.Predetermined;

public interface PredeterminedService {

	public Map<String,Object> addPredetermined(Predetermined predetermined);
	public Map<String,Object> deletePredetermined(String id);
	public Map<String,Object> updatePredetermined(Predetermined predetermined);
	public Map<String,Object> queryPredetermined(int pageNum,int pageCount);
	public Map<String,Object> queryPredeterminedById(String id);
}
