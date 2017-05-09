
package com.virgin.dependency.web;

/**
 * <p>
 * This class represents an HTTP error object
 * </p>
 * .
 *
 * @author VM00436370
 * @project ServiceDependencies
 * @updated DateTime: Oct 21, 2016 12:52:31 PM Author: VM00436370
 */

public class HTTPErrorResponse {

    /** The exception. */
    private String exception;

    /** The message. */
    private String message;

    /**
     * The Constructor.
     *
     * @param pException
     *            the p exception
     * @param pMessage
     *            the p message
     */
    public HTTPErrorResponse( String pException, String pMessage) {
        this.exception = pException;
        this.message = pMessage;
    }

    /**
     * Gets the value of exception.
     *
     * @return returns the property exception
     */

    public String getException() {

        return exception;
    }

    /**
     * Sets the value of property exception with value exception.
     *
     * @param exception
     *            the exception to set
     */

    public void setException( String exception) {
        this.exception = exception;
    }

    /**
     * Gets the value of message.
     *
     * @return returns the property message
     */

    public String getMessage() {

        return message;
    }

    /**
     * Sets the value of property message with value message.
     *
     * @param message
     *            the message to set
     */

    public void setMessage( String message) {
        this.message = message;
    }

}
