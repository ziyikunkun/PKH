package com.neuedu.zhihu.common;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    /*
     *生成验证码，此处可以时字节数组，也可以是串和int
     */
    private char[] CODES = {'2','3','4','5','6','7','8','9','a','s','d','f','g','h','j','k','l','q',
                            'w','e','r','t','y','u','i','o','p','z','x','c','v','b','n','m',
                            'A','S','D','F','G','H','J','K','L','Q',
                            'W','E','R','T','Y','U','I','O','P','Z','X','C','V','B','N','M'};
    private int HEIGHT = 20;
    private int WIDTH = 50;
    //验证码长度
    private int CODELENGTH = 4;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);//当发get请求时，直接调用本类的post请求
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");  //设置返回类型是图片

        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        Font font = new Font("Arial",Font.BOLD,18);
        g.setFont(font);

        Random ra = new Random();

        g.setColor(new Color(ra.nextInt(55)+200,ra.nextInt(55)+200,ra.nextInt(55)+200));
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.BLACK);
        g.drawRect(0,0,WIDTH - 1,HEIGHT-1);

        String code = null;
        for (int i=0;i<CODELENGTH;i++){
            String str = String.valueOf(CODES[ra.nextInt(CODES.length)]);
            code += str;

            g.setColor(new Color(ra.nextInt(200),ra.nextInt(200),ra.nextInt(200)));
            g.drawString(str,12*i+1,16);
        }
        req.getSession().setAttribute("code",code);

        for (int i=0;i<6;i++){
            int x1 = ra.nextInt(WIDTH);
            int x2 = ra.nextInt(WIDTH);
            int y1 = ra.nextInt(HEIGHT);
            int y2 = ra.nextInt(HEIGHT);
            g.drawLine(x1,x2,y1,y2);
        }
        g.dispose();   //关闭g
        OutputStream out = resp.getOutputStream();

        ImageIO.write(image,"JPEG",out);
    }
}
