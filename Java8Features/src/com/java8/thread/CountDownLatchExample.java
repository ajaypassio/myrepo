/**
 * 
 */
package com.java8.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author AK00487304
 *
 */
public class CountDownLatchExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    CountDownLatch countDownLatch=new CountDownLatch(3);
    
    Thread t1=new Thread(new Service(countDownLatch, "Cache Service",3000));
    Thread t2=new Thread(new Service(countDownLatch, "Validation Service",3000));
    Thread t3=new Thread(new Service(countDownLatch, "Alert Service",3000));
    
    t1.start();
    t2.start();
    t3.start();
    
    try {
		countDownLatch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("All services are up");
	}

}
