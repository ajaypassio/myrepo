package com.java8.features;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StaticTest {

	static void test(){
		//System.out.println("static");
	}	
	public static void main(String[] args) {		
		test();
		
		  /* String s1="Sachin ";  
		   String s2="Tendulkar";  
		   s1.concat(s2);
		   //String s3=s1.concat(s2);  
		   System.out.println(s1);  */
		
		String s1="java string";  
		s1.concat("is immutable");  
		System.out.println(s1);  
		s1=s1.concat(" is immutable so assign it explicitly");  
		s1.replace('j','a');
		System.out.println(s1);  
		
		/*int i=1;
		System.out.println(++i);
		int j=1;
		System.out.println(j++);
		System.out.println(j);*/
		
		/*Find out max repeated number*/
		int intarr[]={1,5,4,2,1,3,8,4,1};
		int max=intarr[0];
		int counter=0;
		for(int i=0;i<intarr.length;i++){
			int temCounter=0;
			for(int j=0;j<intarr.length;j++){
				if(intarr[i]==intarr[j]){
					temCounter++;
				}
			}
			if(temCounter>counter){
				max=intarr[i];
				counter=temCounter;
			}
		}
		System.out.print(max);
		/*Reverse the string word*/
		String str="my name is ajay my";
		String arr[]=str.split(" ");
		for(int i=0;i<arr.length;i++){
			for(int j=arr[i].length()-1;j>=0;j--){
				System.out.print(arr[i].charAt(j));
			}
			if(i!=arr.length-1)
			System.out.print(" ");
		}
		/* Find out max repeated string second approach*/
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<arr.length;i++){
		if(map.containsKey(arr[i])){
			map.put(arr[i], map.get(arr[i])+1);
		}else{
			map.put(arr[i], 1);
		}
		}
		
		 List<Map.Entry<String,Integer>> list =
		            new LinkedList<Map.Entry<String,Integer>>( map.entrySet() );
		
		 Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){

			@Override
			public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
			
		});
		
		Map<String,Integer> linkedMap=new LinkedHashMap<String, Integer>();
		for(Map.Entry<String,Integer> entry:list){
			linkedMap.put(entry.getKey(), entry.getValue());
		}
		int i=0;
		for(Map.Entry<String,Integer> entry:linkedMap.entrySet()){
			if(i==0)
			System.out.print(entry.getKey() + " " +entry.getValue() );
			break;
		}
		
		
	}
}
