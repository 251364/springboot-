package com.fly.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	//标注这个方法是异步的
	@Async
	public void hello()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("处理数据中.....");
	}
	
}
