package com.java8.test;

public class Department {
  public String deptName;
  
  public String deptCat;
  
  
  

/**
 * @return the deptName
 */
public String getDeptName() {
	return deptName;
}

/**
 * @param deptName the deptName to set
 */
public void setDeptName(String deptName) {
	this.deptName = deptName;
}

/**
 * @return the deptCat
 */
public String getDeptCat() {
	return deptCat;
}

/**
 * @param deptCat the deptCat to set
 */
public void setDeptCat(String deptCat) {
	this.deptCat = deptCat;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	/*final int prime = 31;
	int result = 1;
	result = prime * result + ((deptCat == null) ? 0 : deptCat.hashCode());
	result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());*/
	return 31;
}

/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Department other = (Department) obj;
	if (deptCat == null) {
		if (other.deptCat != null)
			return false;
	} else if (!deptCat.equals(other.deptCat))
		return false;
	if (deptName == null) {
		if (other.deptName != null)
			return false;
	} else if (!deptName.equals(other.deptName))
		return false;
	return true;
}
  
  
}
