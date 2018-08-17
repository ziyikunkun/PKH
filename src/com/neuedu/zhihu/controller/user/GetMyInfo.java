package com.neuedu.zhihu.controller.user;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.service.IUserService;
import com.neuedu.zhihu.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/needLogin/MyInfo")
public class GetMyInfo extends HttpServlet {

    IUserService userService = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean userBean = new UserBean();
        //获取用户id传入对象
        userBean = userService.selectOne(userBean);
        req.setAttribute("Idcard",userBean.getIdcard());
        req.setAttribute("Idcard",userBean.getIdcard());
        req.setAttribute("Idcard",userBean.getIdcard());
        req.setAttribute("Idcard",userBean.getIdcard());
        req.getRequestDispatcher("/user/MyInfo.jsp").forward(req,resp);


    }
}
