package com.java8.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExampleBlockingQueue {
	
	 public static void main(String[] args)
	   {
	      BlockingQueue<Integer> taskQueue = new LinkedBlockingQueue<Integer>();
	      int MAX_CAPACITY = 5;
	      Thread tProducer = new Thread(new ProducerBlockingQueue(taskQueue, MAX_CAPACITY), "Producer");
	      Thread tConsumer = new Thread(new ConsumerBlockingQueue(taskQueue), "Consumer");
	      tProducer.start();
	      tConsumer.start();
	   }


}
