package com.java8.features;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}

}
