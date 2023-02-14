package com.supermarke.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath(); // 请求路径
        HttpSession session = request.getSession(); // 是否已经登录
        if (path.equals("/sys/login") || session.getAttribute("userSession") != null || path.equals("/loginJudgment")){
            filterChain.doFilter(request,response);
        }else {
            request.setAttribute("log_msg", "您还没有登录，请先登录！");
            request.getRequestDispatcher("/WEB-INF/jsp/frame.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
