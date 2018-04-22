package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.DoBusinessMapper;
import com.pojo.Paging;
import com.service.DoBusinessService;
import com.util.Util;

@Service
public class DoBusinessServiceImpl implements DoBusinessService {
	private final static Map<String,Object> map = new HashMap<String,Object>();
	@Autowired
	private DoBusinessMapper doBusinessMapper;
	@Override
	public Map<String, Object> queryDoBusiness(int pageNum,int pageCount) {
		try{
			int count = doBusinessMapper.queryDoBusinessCount();
			Paging page = Util.paging(count, pageNum, pageCount);
			List<Object> objList = doBusinessMapper.queryDoBusiness(page.getStartCount(), pageCount);
			map.put("page", page);
			map.put("list", objList);
			map.put("status", "200");
			map.put("message", "查询成功！");
		}catch(Exception e){
			map.put("status", "200");
			map.put("message", "查询失败！");
			e.printStackTrace();
		}
		return map;
	}

}
