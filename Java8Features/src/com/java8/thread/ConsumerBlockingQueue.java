package com.java8.thread;

import java.util.concurrent.BlockingQueue;

public class ConsumerBlockingQueue implements Runnable
{
	   private final BlockingQueue<Integer> taskQueue;
	 
	   public ConsumerBlockingQueue(BlockingQueue<Integer> sharedQueue)
	   {
	      this.taskQueue = sharedQueue;
	   }
	 
	   @Override
	   public void run()
	   {
	      while (true)
	      {
	         try
	         {
	            consume();
	         } catch (InterruptedException ex)
	         {
	            ex.printStackTrace();
	         }
	      }
	   }
	 
	   private void consume() throws InterruptedException
	   {
	     
	         while (taskQueue.isEmpty())
	         {
	            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
	            //taskQueue.wait();
	         }
	         Thread.sleep(1000);
	         
	         System.out.println("Consumed: " +taskQueue.take());
	         //taskQueue.notifyAll();
	     
	   }

}
