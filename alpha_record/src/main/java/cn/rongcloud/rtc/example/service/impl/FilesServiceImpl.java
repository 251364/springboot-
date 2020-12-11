package cn.rongcloud.rtc.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcloud.rtc.example.bean.videoFile;
import cn.rongcloud.rtc.example.dao.FilesMapper;
import cn.rongcloud.rtc.example.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService {
	@Autowired
	FilesMapper filesmapper;

	@Override
	public void insertFiles(videoFile files) {

		filesmapper.insertFiles(files);
	}

	@Override
	public void updateFiles(videoFile files) {
		filesmapper.updateFiles(files);
		
	}

}
