/**
 * 
 */
package com.gl.visaapp.exception;

/**
 * @author Ajay Kumar
 *
 */
public class VisaApplicationException extends Exception{

	
	private static final long serialVersionUID = 1501789558617308414L;

	/**
	 * 
	 */
	public VisaApplicationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public VisaApplicationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public VisaApplicationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public VisaApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public VisaApplicationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
