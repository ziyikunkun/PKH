package com.neuedu.zhihu.util.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0util {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("test");

    private static ComboPooledDataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            System.out.println("fffffff");
            return  dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
