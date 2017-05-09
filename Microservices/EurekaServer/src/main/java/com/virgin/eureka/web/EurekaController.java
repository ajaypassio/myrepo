
package com.virgin.eureka.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virgin.dependency.web.CustomHTTPResponse;
import com.virgin.dependency.web.HTTPErrorResponse;

/**
 * The Class EurekaController.
 */
@RestController( "/error")
public class EurekaController implements ErrorController {

    public static Logger       log                 = LoggerFactory.getLogger(EurekaController.class);

    /** The Constant PATH. */
    public static final String PATH                = "/error";

    /** The Constant SUCCESS. */
    public static final String SUCCESS             = "success";

    /** The Constant ERROR. */
    public static final String ERROR               = "error";

    /** The Constant STATUS_CODE_SUCCESS. */
    public static final int    STATUS_CODE_SUCCESS = 200;

    public static final int    STATUS_CODE_500     = 500;
    public static final int    STATUS_CODE_404     = 404;

    public static final String STATUS_MESSAGE_404  = "No matching resource found";

    @ExceptionHandler
    @RequestMapping( value = PATH)
    CustomHTTPResponse error( HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.info("inside Eureka Controller . " + response.getStatus() + " Exception is : " + ex.getStackTrace());
        int statusCode = STATUS_CODE_500;
        HTTPErrorResponse errorResp = new HTTPErrorResponse(ex.getClass().getName(), ex.getMessage());
        if (response.getStatus() == STATUS_CODE_404) {
            statusCode = STATUS_CODE_404;
            errorResp = new HTTPErrorResponse(ex.getClass().getName(), STATUS_MESSAGE_404);
        }
        return new CustomHTTPResponse(ERROR, statusCode, errorResp, request.getRequestURI());
    }

    @Override
    public String getErrorPath() {

        return PATH;

    }

}
