package com.java8.thread;

import java.util.concurrent.Callable;

public class MyThread implements Callable{

	@Override
	public String call() {
		// TODO Auto-generated method stub
		System.out.println("Exexutor Framework example");
		return "Hi";
	}

}
