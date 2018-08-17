package com.neuedu.zhihu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.neuedu.zhihu.util.getDb.*;

public class JdbcUtil {
    private Connection conn=null;

    String driver=JDBCdriver;
    String url=JDBCurl;
    String user=JDBCuser;
    String password=JDBCpassword;

    //JDBC驱动连接，数据库连接
    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        System.out.println("驱动连接测试成功");
        conn= DriverManager.getConnection(JDBCurl,JDBCuser,JDBCpassword);
        System.out.println("数据库连接测试成功");
        return conn;
    }

    //数据库操作次数
    public void commin(PreparedStatement ps) throws SQLException {
        int rs=ps.executeUpdate();//数据库操作次数，executeQuery返回查询的结果集
    }

    //关闭连接
    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
