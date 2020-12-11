package com.fly.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

	//定时任务
	//second , minute, hour, day of month（日）, month ,day of week(周几).
	
	//周一到周六每一分钟运行一次
	//@Scheduled(cron="0 * * * * MON-SAT")
	
	//1,2,3,4每秒运行一次
	//@Scheduled(cron="0,1,2,3,4 * * * * MON-SAT")
	
	//每四秒执行一次
	@Scheduled(cron="0-4 * * * * MON-SAT")
	public void hello() {
		System.out.println("hello......");
	}

	
	}
