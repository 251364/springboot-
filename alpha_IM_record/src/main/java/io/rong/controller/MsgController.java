package io.rong.controller;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.rong.bean.MessageInf;
import io.rong.service.MsgService;
@Controller
public class MsgController {
	@Autowired
	MsgService msgService;

	@SuppressWarnings("deprecation")
	@PostMapping(value="/msg",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void getMessages(
    		@RequestHeader("Signature")   String  sigture,
    		@RequestHeader("Timestamp")   String  timestamp,
    		@RequestHeader("Nonce")   String  nonce,
    		@RequestParam("fromUserId") String  fromuserid,
    		@RequestParam("toUserId") String  touserid,
    		@RequestParam("ObjectName") String  objectname,
    		@RequestParam("content") String  content,
    		@RequestParam("channelType") String  channeltype,
    		@RequestParam("msgTimestamp") String  msgtimestamp,
    		@RequestParam("msgUID") String  msguid,
    		@RequestParam("sensitiveType") Integer sensitivetype,
    		@RequestParam("source") String  source,
    		@RequestParam("groupUserIds") String[] groupuserids
    		
    		){
		
		String appSecret = "Y1W2MeFwwwRxa0";
		/*String signature=*/
		String signature = String.valueOf(DigestUtils.shaHex(appSecret + nonce+timestamp));
		if(signature.equals("sigture")) {
		MessageInf  msginf=new MessageInf();
		msginf.setUserid(fromuserid);
		msginf.setSendtime(new Date(msgtimestamp));
		msginf.setObjectname(objectname);
		msginf.setContent(content);
		msginf.setChannelType(channeltype);
    	msgService.insertMsg(msginf);
		}
      
		else {
			throw new IllegalArgumentException();
		}
    }
	
}
