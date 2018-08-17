package com.neuedu.zhihu.dao.user;

import com.neuedu.zhihu.bean.UpdatePassBean;
import com.neuedu.zhihu.dao.IBaseDao;
import com.neuedu.zhihu.util.c3p0.C3p0util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PassWordDaoImpl implements IBaseDao<UpdatePassBean> {

    private Connection conn = C3p0util.getConnection();

    private static PassWordDaoImpl password;
    private PassWordDaoImpl(){}
    public static PassWordDaoImpl getPassword() {
        if (password == null){
            synchronized (PassWordDaoImpl.class){
                if(password == null){
                    password = new PassWordDaoImpl();
                }
            }
        }
        return password;
    }

    @Override
    public int insertData(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int deleteData(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int updateData(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public List<UpdatePassBean> selectData(UpdatePassBean updatePassBean) {
        return null;
    }

    @Override
    public UpdatePassBean selectOne(UpdatePassBean updatePassBean) throws SQLException {
        String sql = "select * from password where id="+updatePassBean.getId()+"";
        Statement sta = conn.createStatement();
        return null;
    }
}
