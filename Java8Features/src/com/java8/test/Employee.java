package com.java8.test;


public class Employee {
  public String name;
  
  

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public int hashCode() {
	/*final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());*/
	return 31;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
  
}
