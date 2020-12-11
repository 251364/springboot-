package io.rong.bean;

import java.util.Date;

/**
 * @author admin
 *
 */
//记录聊天信息的主类
public class MessageInf {


    private String userid;
	private Date sendtime ;
	private  String objectname;
	private  String content;
	private  String channelType;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getObjectname() {
		return objectname;
	}
	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	@Override
	public String toString() {
		return "MessageInf [userid=" + userid + ", sendtime=" + sendtime + ", objectname=" + objectname + ", content="
				+ content + ", channelType=" + channelType + "]";
	}
	
	
	
}