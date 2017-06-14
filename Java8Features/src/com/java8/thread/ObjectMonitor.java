/**
 * 
 */
package com.java8.thread;

/**
 * @author AK00487304
 *
 */
public class ObjectMonitor {
	public boolean isEvenOdd=false;
	public synchronized void printOdd(int number) throws InterruptedException{
		if(isEvenOdd)
		wait();
		
		System.out.println("Odd Number is "+number);
		isEvenOdd=true;
		notify();
	}
    public synchronized void printEven(int number) throws InterruptedException{
    	if(!isEvenOdd)
    		wait();
    		
    		System.out.println("Even Number is "+number);
    		isEvenOdd=false;
    		notify();
	}

}
