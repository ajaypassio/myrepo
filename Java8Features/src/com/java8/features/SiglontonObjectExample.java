package com.java8.features;

import java.io.Serializable;

public class SiglontonObjectExample implements Cloneable,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1326927937983984907L;
	
	private static SiglontonObjectExample myObj;
    /**
     * Create private constructor
     */
    private SiglontonObjectExample(){
         
    }
    /**
     * Create a static method to get instance.
     */
    public static SiglontonObjectExample getInstance(){
        if(myObj == null){
        	synchronized(myObj){
        	if(myObj==null)
            myObj = new SiglontonObjectExample();
        	}
        }
        return myObj;
    }
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	} 
	
	public Object readResolve() {
		return getInstance();	
	}
    
}
