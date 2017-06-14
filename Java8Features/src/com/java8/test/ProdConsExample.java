package com.java8.test;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProdConsExample {
  public static void  main(String s[]){
	  
	//List<Integer> taskQueue=new ArrayList<Integer>();
	int maxSize=10;
	BlockingQueue<Integer> taskQueue=new ArrayBlockingQueue<Integer>(maxSize);
	
	Thread producer=new Thread(new Producer(taskQueue));
	Thread consumer=new Thread(new Consumer(taskQueue));
	
	producer.start();
	consumer.start();
  }
}
