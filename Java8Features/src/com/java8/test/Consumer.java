package com.java8.test;
import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable{

	//List<Integer> taskQueue;
	
	BlockingQueue<Integer> taskQueue;
	int maxSize;
	/*public Producer(List<Integer> taskQueue,int maxSize){
		this.taskQueue=taskQueue;
		this.maxSize=maxSize;
	}*/
	public Consumer(BlockingQueue<Integer> taskQueue){
	this.taskQueue=taskQueue;	
	}
	
	/*public Consumer(List<Integer> taskQueue){
		this.taskQueue=taskQueue;		
	}*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=1;
		while(count<20){
			/*synchronized (taskQueue) {
				while(taskQueue.isEmpty()){
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			*/
			
			try {
				System.out.println("Consume "+taskQueue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			count++;
			//taskQueue.notify();
			}
		}
	}

}
