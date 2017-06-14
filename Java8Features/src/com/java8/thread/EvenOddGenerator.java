package com.java8.thread;

public class EvenOddGenerator {
	public static void main(String s[]){
		ObjectMonitor objectMonitor=new ObjectMonitor();
		//Thread even=new Thread(new EvenGenerator(objectMonitor));
		//Thread odd=new Thread(new OddGenerator(objectMonitor));
		//odd.start();
		//even.start();
		
		// Lambda Runnable even
		Runnable even = () -> { 	
			
			for(int number=1;number<=20;number++){
			try {
				if(number%2==0)
				objectMonitor.printEven(number);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} 
			};
			
			// Lambda Runnable odd
			Runnable odd = () -> { 	
				
				for(int number=1;number<=20;number++){
				try {
					if(number%2!=0)
					objectMonitor.printOdd(number);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} 
				};
		 
		// start the even thread
		new Thread(even).start();
		// start the even thread
		new Thread(odd).start();
	}

}
