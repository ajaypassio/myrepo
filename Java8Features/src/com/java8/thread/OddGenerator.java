package com.java8.thread;

public class OddGenerator implements Runnable {

	public ObjectMonitor objectMonitor;
	
	public OddGenerator(ObjectMonitor objectMonitor){
		this.objectMonitor=objectMonitor;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int number=1;number<=20;number++){
		try {
			if(number%2!=0)
			objectMonitor.printOdd(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
