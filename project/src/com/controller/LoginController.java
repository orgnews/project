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
}
