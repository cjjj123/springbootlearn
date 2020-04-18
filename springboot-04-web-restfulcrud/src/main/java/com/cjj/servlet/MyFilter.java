package com.cjj.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 *拦截器
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
