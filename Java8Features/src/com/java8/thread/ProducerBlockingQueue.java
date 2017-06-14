package com.java8.thread;

import java.util.concurrent.BlockingQueue;

public class ProducerBlockingQueue implements Runnable{
	   
	   private final BlockingQueue<Integer> taskQueue;
	   private final int           MAX_CAPACITY;
	 
	   public ProducerBlockingQueue(BlockingQueue<Integer> sharedQueue, int size)
	   {
	      this.taskQueue = sharedQueue;
	      this.MAX_CAPACITY = size;
	   }
	 
	   @Override
	   public void run()
	   {
	      int counter = 0;
	      while (true)
	      {
	         try
	         {
	            produce(counter++);
	         } 
	         catch (InterruptedException ex)
	         {
	            ex.printStackTrace();
	         }
	      }
	   }
	 
	   private void produce(int i) throws InterruptedException
	   {
	      
	         while (taskQueue.size() == MAX_CAPACITY)
	         {
	            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            //taskQueue.wait();
	         }
	           
	         Thread.sleep(1000);
	         taskQueue.put(i);
	         System.out.println("Produced: " + i);
	         //taskQueue.notifyAll();
	      }
	   
}
