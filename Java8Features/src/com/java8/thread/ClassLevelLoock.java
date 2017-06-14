package com.java8.thread;


public class ClassLevelLoock implements Runnable{
	
	@Override
    public void run() {
        Lock();
    }

    public void Lock() {
        System.out.println(Thread.currentThread().getName());
        
        	//try {
				//Thread.sleep(100);
				synchronized(ClassLevelLoock.class) {
					for(int i=0;i<5;i++){
						System.out.println("Thread name is " + Thread.currentThread().getName() + " The value is "+i);
					}
				}
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
        
    }

    public static void main(String[] args) {
    	ClassLevelLoock b1 = new ClassLevelLoock();
        Thread t1 = new Thread(b1,"Thread 1");
        Thread t2 = new Thread(b1,"Thread 2");             
        ClassLevelLoock b2 = new ClassLevelLoock();
        Thread t3 = new Thread(b2,"Thread 3");             
                 
        t1.start();
        t2.start();
        t3.start();
    }
}
