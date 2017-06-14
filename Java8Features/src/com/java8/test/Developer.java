package com.java8.test;
import java.math.BigDecimal;

/**
 * 
 */

/**
 * @author AK00487304
 *
 */
public class Developer {

	public String name;
	public BigDecimal salary;
	public int age;
	
	public Developer(String name,BigDecimal salary,int age){
		this.name=name;
		this.salary=salary;
		this.age=age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
