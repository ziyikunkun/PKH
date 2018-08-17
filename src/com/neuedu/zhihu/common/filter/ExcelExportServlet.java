package com.neuedu.zhihu.common.filter;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.service.IUserService;
import com.neuedu.zhihu.service.user.UserServiceImpl;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/needLogin/excel")
public class ExcelExportServlet extends HttpServlet {

    IUserService userService = UserServiceImpl.getUserService();

    ExcelExportServlet(userService, resp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库中取出数据
        List<UserBean> users = userService.getUserList();
    }

    void getExcle(List<UserBean> list,HttpServletResponse resp)throws Exception{  //生成Excle

        resp.setContentType("aplication/ms.excle");
        String sheetName = "用户信息表";//文件名
        sheetName = new String(sheetName.getBytes(),"iso8859-1"); //修改excel文件编码
        resp.addHeader("content-Disposition","attachment;Filename = "+sheetName+".xls");//生成excle

        //开启一个输出流
        OutputStream out = resp.getOutputStream();
        //创建一个表
        WritableWorkbook wwb = Workbook.createWorkbook(out);
        //定义一个空表
        WritableSheet ws = null;
        //创建一个sheet
        ws = wwb.createSheet("用户信息",0);
        //设置excle文件的title
        String[] title = {"用户名","真实姓名","性别","手机号","身份证号"};
        Label label;  //excle单元格
        for (int i = 0 ; i < title.length; i++){   //为表格设置头部
            label = new Label(i,0,title[i]);
            ws.addCell(label);
        }
        int t = 1;
        for (UserBean user : list){  //向表格加入数据
            ws.addCell(new Label(0,t,user.getUname()));
            ws.addCell(new Label(0,t,user.getRename()));
            ws.addCell(new Label(0,t,user.getSex()));
            ws.addCell(new Label(0,t,user.getIDnumber()));
        }
        //给出一个输出
        wwb.write();
        wwb.close();
    }
}
