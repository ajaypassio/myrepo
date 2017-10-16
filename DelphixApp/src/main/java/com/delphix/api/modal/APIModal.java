/**
 * 
 */
package com.delphix.api.modal;

import java.io.Serializable;

/**
 * @author AK00487304
 *
 */
public class APIModal implements Serializable{

	private static final long serialVersionUID = -6571272538562035445L;
	
    public String avgDate;
    public int avgDateCount;
	
    
    /**
	 * 
	 */
	public APIModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param avgDate
	 * @param avgDateCount
	 */
	public APIModal(String avgDate, int avgDateCount) {
		super();
		this.avgDate = avgDate;
		this.avgDateCount = avgDateCount;
	}
	/**
	 * @return the avgDate
	 */
	public String getAvgDate() {
		return avgDate;
	}
	/**
	 * @param avgDate the avgDate to set
	 */
	public void setAvgDate(String avgDate) {
		this.avgDate = avgDate;
	}
	/**
	 * @return the avgDateCount
	 */
	public int getAvgDateCount() {
		return avgDateCount;
	}
	/**
	 * @param avgDateCount the avgDateCount to set
	 */
	public void setAvgDateCount(int avgDateCount) {
		this.avgDateCount = avgDateCount;
	}
    
    
  
  
}
