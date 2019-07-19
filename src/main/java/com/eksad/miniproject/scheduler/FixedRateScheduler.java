package com.eksad.miniproject.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class FixedRateScheduler {
	
	@Scheduled(fixedRate = 5000)
	public void run() throws InterruptedException{
		System.out.println("Fixed rate scheduler is runing at: " + new Date());
		Thread.sleep(3000);
	}

}
