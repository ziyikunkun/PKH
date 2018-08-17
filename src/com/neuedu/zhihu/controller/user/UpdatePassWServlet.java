package com.neuedu.zhihu.controller.user;

import com.neuedu.zhihu.bean.UpdatePassBean;
import com.neuedu.zhihu.common.IBaseService;
import com.neuedu.zhihu.service.user.PassWordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdatePassW")
public class UpdatePassWServlet extends HttpServlet {   //客户主动修改密码

    IBaseService<UpdatePassBean> userService = new PassWordServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断验证码是否正确，从session中获取验证码
        String code = String.valueOf(req.getSession().getAttribute("code"));
        String codeu = String.valueOf(req.getParameter("code"));  //从前端接收输入的验证码
        if (code.equals(codeu)) {   //判断两个验证码是否相同，相同则执行修改密码
            try {

                UpdatePassBean user = new UpdatePassBean();  //创建对象，并将从前端接收的数据赋值给对象封装
                user.setUserName(req.getParameter("userName"));
                user.setOldPass(req.getParameter("oldPass"));
                user.setNewPass(req.getParameter("newPass"));

                int flg = 0;  //执行修改密码操作
                flg = userService.updateInfo(user);
                if (flg != 0) {   //判断修改是否成功
                    resp.getWriter().print("修改成功");
                } else
                    resp.getWriter().print("<script type=\"text/javascript\">\n" +
                            "    alert(\"验证码错误\")\n" +
                            "</script>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
