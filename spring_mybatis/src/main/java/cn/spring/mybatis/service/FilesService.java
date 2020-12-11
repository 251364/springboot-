package cn.spring.mybatis.service;

import cn.spring.mybatis.bean.videoFile;

public interface FilesService {

	   public   videoFile getFilesById(int id);
	   public   videoFile getFilesByChannelId(String channelid);
	   public   void insertFiles(videoFile files); 
	   public   void  updateFiles(videoFile files);
	   
}
