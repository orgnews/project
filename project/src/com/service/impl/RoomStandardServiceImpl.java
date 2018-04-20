package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RoomStandardMapper;
import com.pojo.RoomStandard;
import com.service.RoomStandardService;
import com.util.Util;

@Service
public class RoomStandardServiceImpl implements RoomStandardService{

	@Autowired
	private RoomStandardMapper roomStandardMapper;
	@Override
	public void addRoomStandard(RoomStandard roomStandard) {
		roomStandard.setId(Util.uuid());
		roomStandard.setEstablish_date(Util.date());
		// TODO Auto-generated method stub
		roomStandardMapper.addRoomStandard(roomStandard);
	}

}
