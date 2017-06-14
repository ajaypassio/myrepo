package com.java8.test;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class ConsumerExm implements Runnable{

	List<Integer> taskQueue=new ArrayList<Integer>();
	
	public ConsumerExm(List<Integer> taskQueue){
		this.taskQueue=taskQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				synchronized (taskQueue) {
					while(taskQueue.isEmpty()){
						taskQueue.wait();
					}
					int i=(Integer)taskQueue.remove(0);
					System.out.println("Consumer started consuming"+i);
					taskQueue.notifyAll();
				}
				
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}

}
