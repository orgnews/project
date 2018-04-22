package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.DoBusinessService;

@Controller
public class DoBusinessController {
	private static Map<String,Object> map = new HashMap<String,Object>();
	@Autowired
	private DoBusinessService doBusinessService;
	
	@RequestMapping(value="/doBusiness",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryDoBusiness(int pageNum,int pageCount){
		map.clear();
		map = doBusinessService.queryDoBusiness(pageNum, pageCount);
		return map;
	}
}
