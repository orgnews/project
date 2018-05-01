package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.LoginMapper;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	private final static Map<String,Object> map = new HashMap<String,Object>();
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public Map<String, Object> queryLogin(String username, String password) {
		map.clear();
		try {
			List<Object> objList = loginMapper.queryLogin(username, password);
			if(objList.size()==1){
				Map<String,Object> objMap = (Map<String, Object>) objList.get(0);
				String status = objMap.get("status").toString();
				if(status.equals("1")){
					map.put("status", 400);
					map.put("message", "登陆失败,你在黑明单内");
				}else{
					map.put("list", objList);
					map.put("status", 200);
					map.put("message", "登陆成功");
				}
			}else{
				map.put("status", 403);
				map.put("message", "登陆失败,多个用户名重复");
			}
		} catch (Exception e) {
			map.put("status", 500);
			map.put("message", "登陆失败"+e.getMessage());
		}
		return map;
	}
	
}
