package cn.rongcloud.rtc.example.bean;

import java.util.Date;

/**
 * @author admin
 *
 */
public class videoFile {

	private Integer id;
    private String channelid;
	private long filesize;
	private  String path;
	private  Date  starttime;
	private  Date  stoptime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getStoptime() {
		return stoptime;
	}
	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}
	@Override
	public String toString() {
		return "Files [id=" + id + ", channelid=" + channelid + ", filesize=" + filesize + ", path=" + path
				+ ", starttime=" + starttime + ", stoptime=" + stoptime + "]";
	}

	
	

}
