package com.java1234.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author Administrator
 */
public class LoginFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object object = session.getAttribute("currentUser");
        String path = request.getServletPath();
        if (object == null && path.indexOf("login") < 0 && path.indexOf("bootstrap") < 0                // 如果用户为空或者不是这些请求,那么重定向到login.jsp
                && path.indexOf("images") < 0) {
            response.sendRedirect("login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
