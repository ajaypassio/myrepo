package com.java8.features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachEnhancement {
public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<10; i++)
			myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new MyConsumer() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
		Runnable runnable=() -> {System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");};
		new Thread(runnable).start();
		
	}

}
