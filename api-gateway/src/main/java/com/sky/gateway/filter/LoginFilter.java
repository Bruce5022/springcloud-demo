package com.sky.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        System.out.println("URI地址:" + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL地址:" + requestURL);
        if ("/gateway/order/api/order/save".equalsIgnoreCase(requestURI)) {
//            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("执行方法体内容...");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getHeader("access-token");
        System.out.println("accessToken:" + accessToken);
//        if (StringUtils.isEmpty(accessToken)) {
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
        return null;
    }
}
