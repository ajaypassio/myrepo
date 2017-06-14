package com.java8.test;
import java.util.List;

/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class ProducerExm implements Runnable{

	private final List<Integer> taskQueue;
	private final int max_capacity;
	
	public ProducerExm(List<Integer> taskQueue,int MAX_CAPACITY){
		this.taskQueue=taskQueue;
		this.max_capacity=MAX_CAPACITY;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter=0;
		while(true){
			try{
				synchronized(taskQueue){
					while(taskQueue.size()==max_capacity){
						taskQueue.wait();
					}
					Thread.sleep(1000);
					taskQueue.add(counter++);
					System.out.println("Producer started producing");
					taskQueue.notifyAll();
					
				}
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		
	}

}
