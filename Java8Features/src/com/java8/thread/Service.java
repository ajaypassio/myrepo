/**
 * 
 */
package com.java8.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author AK00487304
 *
 */
public class Service implements Runnable{

	private CountDownLatch countDownLatch;
	String serviceName="";
	int startTime;
	public Service(CountDownLatch countDownLatch,String serviceName,int startTime){
		this.countDownLatch=countDownLatch;
		this.serviceName=serviceName;
	}
	
	@Override
	public void run() {
	try {
		Thread.sleep(startTime);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	countDownLatch.countDown();
	System.out.println("The Service " +serviceName + " started" + "count down value="+ countDownLatch.getCount());
	}
}
