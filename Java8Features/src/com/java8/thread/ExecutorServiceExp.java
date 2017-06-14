package com.java8.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExp {

	public ExecutorServiceExp(){
		
	}
	
	public static void main(String s[]){
		List<Future<String>> futures=new  ArrayList();
		/*ExecutorService service=Executors.newFixedThreadPool(5);
		List<Future<String>> futures= service.invokeAll(new MyThread());*/
		/*ScheduledExecutorService service=Executors.newScheduledThreadPool(5);
		Future<String> futures=service.schedule(new MyThread(),10, TimeUnit.SECONDS);*/
		for(int i=0;i<10;i++){
		ExecutorService service=Executors.newCachedThreadPool();		
		Future<String> future=service.submit(new MyThread());
		futures.add(future);
		}	
		for(Future<String> future:futures){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
