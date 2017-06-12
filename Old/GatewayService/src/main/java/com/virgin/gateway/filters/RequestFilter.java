
package com.virgin.gateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.virgin.gateway.util.Constant;

/**
 * <p>
 * This is a filter class which will be called before a request is pass through Zuul
 * </p>
 * .
 *
 * @author SS00443175
 * @project GatewayService
 * @updated DateTime: Sep 28, 2016 3:23:36 PM Author: SS00443175
 */
public class RequestFilter extends ZuulFilter {

    /** The log. */
    private static Logger       log             = LoggerFactory.getLogger(RequestFilter.class);

    /** The Constant LOG_START_MSG. */
    private static final String LOG_START_MSG   = "Called Request filter";

    /** The Constant LOG_REQUEST_MSG. */
    private static final String LOG_REQUEST_MSG = "request to";

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return Constant.FILTER_TYPE_PRE;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.ZuulFilter#filterOrder()
     */
    @Override
    public int filterOrder() {
        return 1;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s" + Constant.SPACE + LOG_REQUEST_MSG + Constant.SPACE + "%s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
