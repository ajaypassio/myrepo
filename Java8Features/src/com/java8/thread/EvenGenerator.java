package com.java8.thread;

public class EvenGenerator implements Runnable {

	public ObjectMonitor objectMonitor;
	
	public EvenGenerator(ObjectMonitor objectMonitor){
		this.objectMonitor=objectMonitor;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int number=1;number<=20;number++){
		try {
			if(number%2==0)
			objectMonitor.printEven(number);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
