package com.service;

import java.util.Map;

public interface LoginService {
	public Map<String,Object> queryLogin(String username,String password);
	
	public Map<String,Object> addLogin(String username,String password);
	
	public Map<String,Object> queryLoginAll(int pageNum, int pageCount);
	
	public Map<String,Object> saveUserPaw(String username,String old_password,String new_password);
	
	public Map<String,Object> saveBlackStatus(String username,String status);
}
