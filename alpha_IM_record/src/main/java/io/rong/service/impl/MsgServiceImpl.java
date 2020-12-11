package io.rong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rong.bean.MessageInf;
import io.rong.mapper.MsgMapper;
import io.rong.service.MsgService;
@Service
public class MsgServiceImpl implements MsgService {
	@Autowired
	MsgMapper msgMapper;

	
	
	@Override
	public void insertMsg(MessageInf msg) {
	
		msgMapper.insertMsg(msg);
	}

	
	

}
