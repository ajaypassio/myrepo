
package com.virgin.dependency.web;

/**
 * <p>
 * This is a custom response type return by each end points
 * </p>
 * .
 *
 * @author ss00443175
 * @project ServiceDependencies
 * @updated DateTime: Oct 19, 2016 4:40:15 PM Author: ss00443175
 */

public class CustomHTTPResponse {

    /** The status. */
    private String status;

    /** The status code. */
    private int    statusCode;

    /** The data. */
    private Object data;

    /** The path. */
    private String path;

    /**
     * The Constructor.
     *
     * @param pStatus
     *            the p status
     * @param pStatusCode
     *            the p status code
     * @param pData
     *            the p data
     * @param pPath
     *            the p path
     */
    public CustomHTTPResponse( String pStatus, int pStatusCode, Object pData, String pPath) {
        this.status = pStatus;
        this.statusCode = pStatusCode;
        this.data = pData;
        this.path = pPath;
    }

    /**
     * Gets the value of status.
     *
     * @return returns the property status
     */

    public String getStatus() {

        return status;
    }

    /**
     * Sets the value of property status with value status.
     *
     * @param status
     *            the status to set
     */

    public void setStatus( String status) {
        this.status = status;
    }

    /**
     * Gets the value of statusCode.
     *
     * @return returns the property statusCode
     */

    public int getStatusCode() {

        return statusCode;
    }

    /**
     * Sets the value of property statusCode with value statusCode.
     *
     * @param statusCode
     *            the statusCode to set
     */

    public void setStatusCode( int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the value of data.
     *
     * @return returns the property data
     */

    public Object getData() {

        return data;
    }

    /**
     * Sets the value of property data with value data.
     *
     * @param data
     *            the data to set
     */

    public void setData( Object data) {
        this.data = data;
    }

    /**
     * Gets the value of path.
     *
     * @return returns the property path
     */

    public String getPath() {

        return path;
    }

    /**
     * Sets the value of property path with value path.
     *
     * @param path
     *            the path to set
     */

    public void setPath( String path) {
        this.path = path;
    }

}
