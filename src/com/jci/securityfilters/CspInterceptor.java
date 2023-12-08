package com.jci.securityfilters;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CspInterceptor implements HandlerInterceptor {

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        // Set the Content Security Policy header
	        response.setHeader("Content-Security-Policy", "default-src 'self'");

	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                           ModelAndView modelAndView) throws Exception {
	        // Post-handle code, if needed
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	                                Exception ex) throws Exception {
	        // After-completion code, if needed
	    }
}
