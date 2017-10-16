/**
 * 
 */
package com.gl.visaapp.utility;

/**
 * @author Ajay Kumar
 *
 */
public enum JobType {
	G("Government"), 
	P("Private"), 
	S("Self");
	
	private final String value;
    

    JobType(String value) {
        this.value = value;       
    }

  
    public String getValue() {
        return this.value;
    }   
   
}
