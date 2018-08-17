package com.neuedu.zhihu.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/needLogin/*")
public class NeedLoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        //必须类型转换，才能使用session
        if (req.getSession().getAttribute("loginName") != null){   //判断是否登录
            //业务逻辑
            chain.doFilter(request,resp);  //  执行所请求的url
            resp.getWriter().print("查询成功");
        }else
            resp.getWriter().print("请先登录");
    }

    @Override
    public void destroy() {

    }
}
