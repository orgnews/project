package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Reception;
import com.service.ReceptionService;

@Controller
public class ReceptionController {
	
	@Resource
	private ReceptionService receptionService;
	
	@RequestMapping(value="/reception",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addReception(Reception reception){
		return receptionService.addReception(reception);
	}
	
	@RequestMapping(value="/delReception",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteReception(String id){
		return receptionService.deleteReception(id);
	}
	
	@RequestMapping(value="/updateReception",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateReception(Reception reception){
		return receptionService.updateReception(reception);
	}
	@RequestMapping(value="/queryReception",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryReception(int pageNum, int pageCount,String findCondition){
		return receptionService.queryReception(pageNum, pageCount,findCondition);
	}
	
	@RequestMapping(value="/queryReceptionById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryReceptionById(String id){
		return receptionService.queryReceptionById(id);
	}
}
