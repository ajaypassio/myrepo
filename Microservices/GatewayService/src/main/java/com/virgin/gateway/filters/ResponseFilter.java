
package com.virgin.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.netflix.zuul.ZuulFilter;
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

public class ResponseFilter extends ZuulFilter {

    /** The log. */
    private static Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    /** The header allow origin. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Origin}")
    private String        headerAllowOrigin;

    /** The header allow credentials. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Credentials}")
    private String        headerAllowCredentials;

    /** The header allow methods. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Methods}")
    private String        headerAllowMethods;

    /** The header allow headers. */
    @Value( "${gatewayService.responseFilter.Access-Control-Allow-Headers}")
    private String        headerAllowHeaders;

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
        return 998;
    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#shouldFilter()
     */

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("Response Filter");
        return null;

    }

    /*
     * (non-Javadoc)
     * @see com.netflix.zuul.IZuulFilter#run()
     */

}
