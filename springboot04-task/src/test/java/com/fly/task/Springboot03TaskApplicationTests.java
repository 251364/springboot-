package com.fly.task;

import java.io.File;


import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03TaskApplicationTests {
/*
   在自动配置里面springbootAutoConfiguration里面找到mail,MailSenderPropertiesConfig就是发邮件的
   
*private void applyProperties(JavaMailSenderImpl sender) {
*/
	@Autowired
	JavaMailSenderImpl  mailSender;
	
	
	
	//简单邮件发送
	@Test
	public void contextLoads() {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setSubject("标题：通知");
		message.setText("内容：开会");
		message.setTo("891842157@qq.com");
		message.setFrom("2551362735@qq.com");
		mailSender.send(message);
	}
	
	//复杂邮件发送
	@Test
	public void test02() throws Exception {
		//创建一个复杂的邮件消息
	MimeMessage mineMessage=mailSender.createMimeMessage();
    MimeMessageHelper helper= new MimeMessageHelper(mineMessage, true);
		
    helper.setSubject("标题：这是个复杂的邮件传输");
    helper.setText("<b style='color:red'>今天添加了html格式的内容</b>",true);
    helper.setTo("891842157@qq.com");
    helper.setFrom("2551362735@qq.com");
    //上传文件
    helper.addAttachment("2.jpg", new File("C:\\Users\\admin\\Pictures\\Saved Pictures\\2.jpg"));
		mailSender.send(mineMessage);
	}

}
