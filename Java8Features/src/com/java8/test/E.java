package com.java8.test;
/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class E implements B,D{

	@Override
	public void print(){
		System.out.println("DDDDDDDDDDD");
	}
	
	E(){
		D.super.print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new E());
		new E().print();
	}

}
