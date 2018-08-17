package com.neuedu.zhihu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getDb {
    public static final String JDBCdriver ;
    public static final String JDBCurl;
    public static final String JDBCuser;
    public static final String JDBCpassword;

    static {
        Properties pro = new Properties();
        InputStream is = getDb.class.getResourceAsStream("/db");//斜杠表示根目录
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBCdriver = pro.getProperty("driver");
        JDBCurl = pro.getProperty("url");
        JDBCuser=pro.getProperty("user");
        JDBCpassword=pro.getProperty("password");
    }

}
