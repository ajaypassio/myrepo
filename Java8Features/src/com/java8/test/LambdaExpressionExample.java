package com.java8.test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LambdaExpressionExample {
	
	

	public static void main(String[] args) {
		
				List<Developer> result = new ArrayList<Developer>();
		
				result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
				result.add(new Developer("alvin", new BigDecimal("80000"), 20));
				result.add(new Developer("jason", new BigDecimal("100000"), 10));
				result.add(new Developer("iris", new BigDecimal("170000"), 55));

			
				
				//map.put("", value)
		
		       //lambda here!
				Collections.sort(result,(Developer o1, Developer o2)->o1.getAge()-o2.getAge());
				
				//lambda here! with sort method list
				//result.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
				
			

				//java 8 only, lambda also, to print the List
				result.forEach((developer)->System.out.println(developer.getAge()));
	}

}
