package cn.spring.mybatis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.spring.mybatis.bean.videoFile;
import cn.spring.mybatis.service.FilesService;


@RestController
public class FilesController {
    @Autowired
   FilesService  filesservice;
    
    @GetMapping("/file/{id}")
    public videoFile getFiles(@PathVariable("id") Integer id){
       return filesservice.getFilesById(id);
    }
    
    
    @GetMapping("/files/{channelid}")
    public videoFile getAllFiles(@PathVariable("channelid") String  channelid){
       return filesservice.getFilesByChannelId(channelid);
    }
    

    /*    
    //@PathVariable获取URL上的值可以作用于get方法
    @GetMapping("/msg/{id}")
    public MessageInf getMessages(@PathVariable("id") Integer id){
       return msgService.getMsgById(id);
    } 
    
    @PostMapping("/msg")
	//@RequestBody作用于实体类或者对象，只作用于post
	public void getMsg(@RequestBody JSONObject jsonObject){
	
		String a=jsonObject.get("id").toString();
		Integer id=Integer.parseInt(a);
		msgService.getMsgById(id);
		
}     
	 @GetMapping("/msgs")//或者@PostMapping("/msgs")
	 //你可以使用@RequestParam注解将请求参数绑定到你控制器的方法参数上
	 //（1）配置一个属性,@RequestParam("") 或 @RequestParam(value="")
	 //（2）配置多个属性 ,@RequestParam(value="", required=true, defaultValue="")
	    public MessageInf getMsgg(@RequestParam("id") Integer id){
	       return msgService.getMsgById(id);
	    } 
	    
	*/
  /*  public void getMessages(@RequestHeader("name") String name, @RequestParam("id") String id)*/
    
    
    
  
}
