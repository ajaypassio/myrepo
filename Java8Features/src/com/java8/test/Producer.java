package com.java8.test;
import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable{

	//List<Integer> taskQueue;
	BlockingQueue<Integer> taskQueue;
	int maxSize;
	/*public Producer(List<Integer> taskQueue,int maxSize){
		this.taskQueue=taskQueue;
		this.maxSize=maxSize;
	}*/
	public Producer(BlockingQueue<Integer> taskQueue){
	this.taskQueue=taskQueue;
	//this.maxSize=maxSize;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=0;
		while(count<20){
			/*synchronized (taskQueue) {
				while(taskQueue.size()==maxSize){
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
			
			try {
				taskQueue.put(count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produce "+count);
			count++;
			//taskQueue.notify();
			
		}
	}

}
