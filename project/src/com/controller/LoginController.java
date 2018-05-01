package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.LoginService;

@Controller
public class LoginController {

	private static Map<String,Object> map = new HashMap<String,Object>();
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/queryLogin" ,method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> login(String username,String password){
		map.clear();
		map = loginService.queryLogin(username, password);
		return map;
	}
	
	@RequestMapping(value="/queryLogin" ,method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addLogin(String username,String password){
		map.clear();
		map = loginService.addLogin(username, password);
		return map;
	}
	
	@RequestMapping(value="/queryLoginAll",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryLoginAll(int pageNum,int pageCount){
		map.clear();
		map = loginService.queryLoginAll(pageNum, pageCount);
		return map;
	}
	
	@RequestMapping(value="/saveUserPaw",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveUserPaw(String username,String old_password,String new_password){
		map.clear();
		map = loginService.saveUserPaw(username,old_password,new_password);
		return map;
	}
	
	@RequestMapping(value="/saveBlackStatus",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveBlackStatus(String username,String status){
		map.clear();
		map = loginService.saveBlackStatus(username,status);
		return map;
	}
	
	
}
