
package com.virgin.gateway.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.virgin.dependency.web.CustomHTTPResponse;
import com.virgin.dependency.web.HTTPErrorResponse;

/**
 * The Class GatewayController.
 */
@RestController
public class GatewayController implements ErrorController {

    public static Logger       log                 = LoggerFactory.getLogger(GatewayController.class);

    /** The Constant PATH. */
    public static final String PATH                = "/error";

    /** The Constant SUCCESS. */
    public static final String SUCCESS             = "success";

    /** The Constant ERROR. */
    public static final String ERROR               = "error";

    /** The error attributes. */
    @Autowired
    ErrorAttributes            errorAttributes;

    /** The Constant STATUS_CODE_SUCCESS. */
    public static final int    STATUS_CODE_SUCCESS = 200;

    public static final int    STATUS_CODE_500     = 500;
    public static final int    STATUS_CODE_404     = 404;

    public static final String STATUS_MESSAGE_404  = "No matching resource found";

    /**
     * Error.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the error json
     */
    @ExceptionHandler( Exception.class)
    @RequestMapping( value = PATH)
    CustomHTTPResponse error( HttpServletRequest request, HttpServletResponse response) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> error = getErrorAttributes(request, true, requestAttributes);
        Throwable exception = errorAttributes.getError(requestAttributes);
        int statusCode = (Integer) error.get("status");
        String message = exception.getMessage();
        HTTPErrorResponse errorResp = new HTTPErrorResponse(exception.getClass().getName(), message);
        return new CustomHTTPResponse(ERROR, statusCode, errorResp, request.getRequestURI());
    }

    /**
     * Gets the error attributes.
     *
     * @param request
     *            the request
     * @param includeStackTrace
     *            the include stack trace
     * @param requestAttributes
     *            the request attributes
     * @return the error attributes
     */
    private Map<String, Object> getErrorAttributes( HttpServletRequest request, boolean includeStackTrace, RequestAttributes requestAttributes) {

        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    @Override
    public String getErrorPath() {

        return PATH;

    }
}
