package com.jci.securityfilters;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.net.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XFrameOptionsFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.addHeader(HttpHeaders.X_FRAME_OPTIONS, "DENY"); // or "SAMEORIGIN" or "ALLOW-FROM uri"
        return true;
    }
}



