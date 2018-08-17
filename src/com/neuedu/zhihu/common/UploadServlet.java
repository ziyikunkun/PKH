package com.neuedu.zhihu.common;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/headUpload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //判断文件存储路径文件夹是否存在
            String savePath = this.getServletContext().getRealPath("/upload");//获取当前的根目录，的父目录
            File file = new File(savePath);
            //判断文件是否存在以及是否时一个文件夹
            if (file.exists() && !file.isDirectory()){
                file.mkdir();
            }
            /*
             * apache服务器文件上传流程
             * 1、创建DiskFileItemFactory
             */
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件解析器ServletFileUpload
            ServletFileUpload upload = new ServletFileUpload(factory);
            //3、设置编码
            upload.setHeaderEncoding("UTF-8");
            //4、判断数据是否时表单数据（文本/文件）
            if (!upload.isMultipartContent(req)){  //传输方式的提交
                return;
            }
            //5、ServletFileUpload处理为FileItem的list集合
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem item : list){
                if (!item.isFormField()){
                    //获取文件名字
                    String filename = item.getName();
                    //保存文件当前名字（老名字）
                    String oldname = filename.substring(filename.lastIndexOf("\\")+1);  //第一个\表示转意
                    if (filename == null || filename.isEmpty()){
                        continue;
                    }
                    //给文件取新名，按照时间和文件格式
                    filename = new Date().getTime()+filename.substring(filename.lastIndexOf("."));
                    //获取文件输入流
                    InputStream in = item.getInputStream();
                    //开启一个输出流
                    FileOutputStream out = new FileOutputStream(savePath+"\\"+filename);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while((len=in.read(bytes))!=-1){
                        out.write(bytes,0,len);  //字符级？
                    }
                    in.close();
                    out.close();
                    item.delete();

                    resp.getWriter().print(savePath+"\\"+filename);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
