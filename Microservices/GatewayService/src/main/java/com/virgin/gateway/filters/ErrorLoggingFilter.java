
package com.virgin.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.virgin.gateway.util.Constant;

/**
 * <p>
 * This class is used for Zuul error logging
 * </p>
 * .
 *
 * @author SS00443175
 * @project GatewayService
 * @updated DateTime: Aug 22, 2016 6:51:04 PM Author: SS00443175
 */

public class ErrorLoggingFilter extends ZuulFilter {

    /** The logger. */
    private final Logger        log           = LoggerFactory.getLogger(getClass());

    /** The Constant LOG_START_MSG. */
    private static final String LOG_START_MSG = "Called Error filter";

    /** The Constant LOG_REQUEST_MSG. */
    private static final String LOG_ERROR_MSG = "Exception was thrown in filters";

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return Constant.FILTER_TYPE_ERROR;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */
    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getThrowable() != null;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#run()
     */
    @Override
    public Object run() {
        log.debug(LOG_START_MSG);
        Throwable throwable = RequestContext.getCurrentContext().getThrowable();
        log.error(LOG_ERROR_MSG + Constant.COLON + Constant.SPACE, throwable);
        return null;
    }

}
