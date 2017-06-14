package com.java8.test;
import java.util.ArrayList;
import java.util.List;


public class ThreadTest {
public static void main(String s[]){
	final List<Integer> taskQueue=new ArrayList<Integer>();
	ProducerExm producer=new ProducerExm(taskQueue, 5);
	ConsumerExm consumer=new ConsumerExm(taskQueue);
	Thread t1=new Thread(producer);
	Thread t2=new Thread(consumer);
	t1.start();
	t2.start();
}
}
