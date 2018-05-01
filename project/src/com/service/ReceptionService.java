package com.service;

import java.util.Map;

import com.pojo.Reception;

public interface ReceptionService {
	public Map<String,Object> addReception(Reception reception);
	public Map<String,Object> deleteReception(String id);
	public Map<String,Object> updateReception(Reception reception);
	public Map<String,Object> queryReception(int pageNum,int pageCount,String findCondition);
	public Map<String,Object> queryReceptionById(String id);
}
