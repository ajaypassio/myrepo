package com.java8.thread;
/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class ObjectLevelLockExample implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectLevelLockExample o1=new ObjectLevelLockExample();
		Thread t1=new Thread(o1,"Thread1");
		Thread t2=new Thread(o1,"Thread2");
		
		ObjectLevelLockExample o2=new ObjectLevelLockExample();
		Thread t3=new Thread(o2,"Thread3");
		t1.start();
		t2.start();		
		t3.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			try {
				Thread.sleep(100);
				synchronized(this){
					for(int i=0;i<5;i++){
						System.out.println("Thread name is " + Thread.currentThread().getName() + " The value is "+i);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
