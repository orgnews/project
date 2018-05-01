package com.service;

import java.util.Map;

public interface LoginService {
	public Map<String,Object> queryLogin(String username,String password);
}
