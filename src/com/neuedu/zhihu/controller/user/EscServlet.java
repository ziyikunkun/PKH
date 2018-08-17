package com.neuedu.zhihu.controller.user;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Esc")
public class EscServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();  //获取session从req中
        //从session中获取用户名
        String username = session.getAttribute("loginName")+ "";   //转换为string
       // String username1 = String.valueOf(session.getAttribute("loginName"));  //同上
        session.removeAttribute(username);//退出关闭用户名密码
        session.removeAttribute("userName");//退出状态
        resp.getWriter().print("退出成功");
    }
}
