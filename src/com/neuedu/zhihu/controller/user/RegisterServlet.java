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
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.neusoft.servletTest.util.MapUtil.mapToObject;

//等同于xml文件中的注册代码，相当于给本类赋值一个uri，注意servlet和filter
@WebServlet("/register")

public class RegisterServlet extends HttpServlet{
    //创建数据处理对象
    UserServiceImpl userService = UserServiceImpl.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码格式  用filter就不需要了
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("GBK");

        //通过req获取前端提交的数据信息
       UserBean user = new UserBean();//将前端获取的数据封装到UserBean中
//        String name = req.getParameter("username").toString();
//        String pass=req.getParameter("password");
//        String rname = req.getParameter("realname");
//        String sex = req.getParameter("sex");
//        int age = Integer.parseInt(req.getParameter("age"));
//        String brith = req.getParameter("brithday");
//        String id_card= req.getParameter("IDnumber");

        //此方法userbean必须与前端所有相对应
        Map param = new HashMap();
        Enumeration<String> keys = req.getParameterNames();//获取所有的key值
        while (keys.hasMoreElements()){  //遍历所有的key
            String key = keys.nextElement();
            param.put(key,req.getParameter(key)); //将从前端取出的数据放入map集合中，键值对形式
        }
        try {
            user = (UserBean) mapToObject(param,UserBean.class);  //map转换为bean对象，原理类反射 param
        } catch (Exception e) {
            e.printStackTrace();
        }

        //将从前端获取到的数据进行封装
//        user.setUname(req.getParameter("username").toString());
//        user.setPassword(req.getParameter("password"));
//        user.setRename(req.getParameter("realname"));
//        user.setWebSex(req.getParameter("sex"));
//        user.setAge(Integer.parseInt(req.getParameter("age")));
//        user.setBirth(req.getParameter("brithday"));
//        user.setId_card(req.getParameter("IDnumber"));

        //对封装信息UserBean进行业务处理
       int i = userService.insertInfo(user);

       //创建一个业务输出流，用于页面反馈信息
        PrintWriter out = resp.getWriter();
       if(i!=0)   //"1".equals(user.getWebSex().tostring())
           out.println("注册成功");
       else
           out.println("注册失败");

    }
}
