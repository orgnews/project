package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.LoginMapper;
import com.pojo.Paging;
import com.service.LoginService;
import com.util.Util;

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
			}else if(objList.size()<1){
				map.put("status", 404);
				map.put("message", "用户名或密码错误");
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

	@Override
	public Map<String, Object> addLogin(String username, String password) {
		map.clear();
		try {
			List<Object> objList = loginMapper.queryLogin(username, password);
			if(objList.size()==1){
				map.put("status", 403);
				map.put("message", "用户名已存在,请勿重复添加");
			}else{
				loginMapper.addLogin(username,password);
				map.put("status", 200);
				map.put("message", "注册成功");
			}
		} catch (Exception e) {
			map.put("status", 500);
			map.put("message", "注册失败:"+e.getMessage());
		}
		return map;
	}

	@Override
	public Map<String, Object> queryLoginAll(int pageNum, int pageCount) {
		map.clear();
		try {
			int count = loginMapper.queryLoginCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = loginMapper.queryLoginAll(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		} catch (Exception e) {
			map.put("status", "500");
			map.put("message", "查询失败！"+e.getMessage());
		}
		return map;
	}

	@Override
	public Map<String, Object> saveUserPaw(String username, String old_password, String new_password) {
		map.clear();
		try {
			List<Object> objList = loginMapper.queryLogin(username, old_password);
			if(objList.size()==1){
				//修改
				loginMapper.updateLogin(username, new_password);
				map.put("status", 200);
				map.put("message", "修改成功");
			}else{
				map.put("status", 403);
				map.put("message", "用户名或密码不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
			map.put("message", "修改密码失败:"+e.getMessage());
		}
		return map;
	}

	@Override
	public Map<String, Object> saveBlackStatus(String username, String status) {
		map.clear();
		try {
			loginMapper.saveBlackStatus(username,status);
			map.put("status", "200");
			map.put("message", "保存成功");
		} catch (Exception e) {
			map.put("status",500);
			map.put("message", "保存失败"+e.getMessage());
		}
		return map;
	}
	
}
