package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Predetermined;
import com.service.PredeterminedService;

@Controller
public class PredeterminedController {
	private static Map<String,Object> map = new HashMap<String,Object>();

	@Resource
	private PredeterminedService predeterminedService;
	
	@RequestMapping(value="/predetermined",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addPredetermined(Predetermined predetermined){
		map.clear();
		map = predeterminedService.addPredetermined(predetermined);
		return map;
	}
	
	@RequestMapping(value="/predetermined",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryPredetermined(int pageNum,int pageCount){
		map.clear();
		map = predeterminedService.queryPredetermined(pageNum, pageCount);
		return map;
	}
	
	@RequestMapping(value="/predeterminedById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> queryPredeterminedById(String id){
		map.clear();
		map = predeterminedService.queryPredeterminedById(id);
		return map;
	}
	
	@RequestMapping(value="/deletePredetermined",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deletePredetermined(String id){
		map.clear();
		map = predeterminedService.deletePredetermined(id);
		return map;
	}
	
	@RequestMapping(value="/updatePredetermined",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updatePredetermined(Predetermined predetermined){
		map.clear();
		map = predeterminedService.updatePredetermined(predetermined);
		return map;
	}
}
