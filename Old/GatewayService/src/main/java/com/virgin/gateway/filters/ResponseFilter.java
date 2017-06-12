
package com.virgin.gateway.filters;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.virgin.gateway.util.Constant;

/**
 * <p>
 * This is the class which gets called after request gets processed from Zuul
 * </p>
 * .
 *
 * @author SS00443175
 * @project GatewayService
 * @updated DateTime: Aug 17, 2016 3:53:51 PM Author: SS00443175
 */

@Component
public class ResponseFilter extends ZuulFilter {

    /** The log. */
    private static Logger       log                      = LoggerFactory.getLogger(ResponseFilter.class);

    /** The Constant LOG_START_MSG. */
    private static final String LOG_START_MSG            = "Called Response filter";

    /** The Constant HEADER_ALLOW_ORIGIN. */
    private static final String HEADER_ALLOW_ORIGIN      = "Access-Control-Allow-Origin";

    /** The Constant HEADER_ALLOW_CREDENTIALS. */
    private static final String HEADER_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

    /** The Constant HEADER_ALLOW_METHODS. */
    private static final String HEADER_ALLOW_METHODS     = "Access-Control-Allow-Methods";

    /** The Constant HEADER_ALLOW_HEADERS. */
    private static final String HEADER_ALLOW_HEADERS     = "Access-Control-Allow-Headers";

    /** The header allow origin. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Origin}")
    private String              headerAllowOrigin;

    /** The header allow credentials. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Credentials}")
    private String              headerAllowCredentials;

    /** The header allow methods. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Methods}")
    private String              headerAllowMethods;

    /** The header allow headers. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Headers}")
    private String              headerAllowHeaders;

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */

    @Override
    public String filterType() {
        return Constant.FILTER_TYPE_POST;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */

    @Override
    public int filterOrder() {
        return 999;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#run()
     */

    @Override
    public Object run() {
        log.debug(LOG_START_MSG);
        try {
            addResponseHeaders();
        } catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }

        return null;
    }

    /**
     * Adds the response headers.
     */
    private void addResponseHeaders() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        response.addHeader(HEADER_ALLOW_ORIGIN, headerAllowOrigin);
        response.addHeader(HEADER_ALLOW_CREDENTIALS, headerAllowCredentials);
        response.addHeader(HEADER_ALLOW_METHODS, headerAllowMethods);
        response.addHeader(HEADER_ALLOW_HEADERS, headerAllowHeaders);
    }

}
