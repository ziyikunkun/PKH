package com.neuedu.zhihu.controller.user;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    UserServiceImpl userService = UserServiceImpl.getUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean user = new UserBean();
        HttpSession session = req.getSession();    //获取session,位于request中
        // 从前端获取用户名和密码
        String userName = req.getParameter("username");
        String pass = req.getParameter("userpass");

        //调用数据库，其目的是判断该用户是否注册
        user.setUname(userName);
        user.setPassword(pass);
        UserBean userBean = userService.selectOne(user);
        //if (userBean!==null && !"".equals(userBean.getUname())){}

        Object loginName = session.getAttribute("loginName");
        //类似于map。设置和获取里面的值
        if ((loginName == null||"".equals(loginName))||!loginName.equals(userName)){
            //判断登录名是否为空，及是否有登录
            session.setAttribute(userName,pass);   //类似Map（键值对） map.put()
            //往session中存入用户名和密码（键值对形式）
            session.setAttribute("loginName",userName);//userName可以是一个对象
            //往session中存入一个登录名称的状态（键值对形式）

            //resp.getWriter().print("登录成功");
            resp.sendRedirect("/user/loginSuccess.jsp");//重定向 返回的是一个uri也可以是jsp
            //req.getRequestDispatcher("/user/loginSuccess.jsp"); //请求转发
        }else
            //resp.getWriter().print("登录失败");
            resp.sendRedirect("/user/loginError.jsp");
            //req.getRequestDispatcher("/user/loginSuccess.jsp");
    }
}
