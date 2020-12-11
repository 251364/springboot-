package cn.rongcloud.rtc.example.dao;
import org.springframework.stereotype.Repository;
import cn.rongcloud.rtc.example.bean.videoFile;

//@Mapper或者@MapperScan将接口扫描装配到容器中

@Repository
public interface FilesMapper {

	   public   int   insertFiles(videoFile files); 
	    public  int  updateFiles(videoFile  files);
}
