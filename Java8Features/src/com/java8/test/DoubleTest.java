package com.java8.test;
import java.util.HashMap;
import java.util.Map;


public class DoubleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* double val1=100.0d;
        double val2=50.d;
		char d='b';
		double result;
       
       if(d=='a') 
    	   result=val1+val2;         
       else if(d=='b') 
    	   result=val1/val2;
       else
    	System.out.println("error"); 
        result=0.0d; 
        System.out.println(result); */
		
		/*for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				System.out.print("4");				
			}
			System.out.println();
		}*/
		
		Map<Employee, Department> map = new HashMap<Employee, Department>();
		
		Employee  employee=new Employee();
		employee.setName("Prahlad");
		
		Department department=new Department();
		department.setDeptCat("AA");
		department.setDeptName("BB");
		
		Employee  employee1=new Employee();
		employee1.setName("Ajay");
		
		Department department1=new Department();
		department1.setDeptCat("AA");
		department1.setDeptName("BB");
		
		map.put(employee, department);
		map.put(employee1, department1);
		
		for (Map.Entry<Employee, Department> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey().getName() + " Value : " + entry.getValue().getDeptCat());
		}
		
		
		/*long startTime=System.currentTimeMillis();
		//Java 8 only, forEach and Lambda
		map.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
        long endTime=System.currentTimeMillis();
		
		System.out.println("Time Taken in Java 8 lambda " + (endTime-startTime));
		
		startTime=System.currentTimeMillis();
		//loop a Map
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
        endTime=System.currentTimeMillis();
		
		System.out.println("Time Taken in map entry " + (endTime-startTime));
		
		startTime=System.currentTimeMillis();
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		  Map.Entry<String, String> entry = entries.next();		  
		  System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());		
		}
        endTime=System.currentTimeMillis();
		
		System.out.println("Time Taken in Java 4 " + (endTime-startTime));
		*/
		/*
		 try{
			System.exit(0);;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Out");
		}
		 */
    	   
	}

}
