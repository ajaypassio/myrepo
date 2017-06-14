package com.java8.test;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class DuplicateValueInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]={1,2,3,3,4,5,5,6,7,7};
		//First way
		/*for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]==arr[j] && i!=j){
					System.out.println("Duplicate value=" +arr[i]);
				}
			}
		}*/
		//Second way
		Set<Integer> set=new HashSet<Integer>();
		for (Integer i:arr){
			if(set.contains(i)){
				//System.out.println("Duplicate Value="+i);
				continue;
			}
			System.out.println("Unique Value="+i);
			set.add(i);
		}
			

	}

}
