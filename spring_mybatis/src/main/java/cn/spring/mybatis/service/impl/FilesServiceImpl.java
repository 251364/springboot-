package cn.spring.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.spring.mybatis.bean.videoFile;
import cn.spring.mybatis.mapper.FilesMapper;
import cn.spring.mybatis.service.FilesService;



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

	@Override
	public videoFile getFilesById(int id) {
		// TODO Auto-generated method stub
		return filesmapper.getFilesById(id);
	}

	@Override
	public videoFile getFilesByChannelId(String channelid) {
		// TODO Auto-generated method stub
		return filesmapper.getFilesByChannelId(channelid);
	}

}
