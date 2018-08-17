package com.neuedu.zhihu.dao.user;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.dao.IBaseDao;
import com.neuedu.zhihu.util.c3p0.C3p0util;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

public class UserDaoImpl implements IBaseDao<UserBean> {
    //保证数据安全，采用单例模式
    private static UserDaoImpl userdao;
    private UserDaoImpl(){ };
    //懒汉模式
    public static UserDaoImpl getUserDao(){
        //判断userdao是否存在，不存在就创建一个，但是需要加同步
        if (userdao==null){
            //对本类进行同步
            synchronized (UserDaoImpl.class){
                //判断userdao是否为空
                if (userdao==null){
                    userdao = new UserDaoImpl();
                }
            }
        }
        return userdao;
    }

    private Connection conn = C3p0util.getConnection();
    @Override
    public int insertData(UserBean userBean) {
        try {
            String sql_insert = "insert into userinfo(uname,password,rname,sex,age,brithday,id_card,isRemove) values(?,?,?,?,?,?,?,?)";
                   // "('"+userBean.getUname()+"','"+userBean.getPassword()+"','"+userBean.getRename()+"'," +
                  //  "'"+userBean.getSqlsex()+"',"+userBean.getAge()+",'"+userBean.getBirth()+"','"+userBean.getIDnumber()+"',"+userBean.getIsRemove()+")";

            PreparedStatement ps = conn.prepareStatement(sql_insert);
            //Statement sta=conn.createStatement();
            //int i=sta.executeUpdate(sql_insert);

            ps.setString(1,userBean.getUname());
            ps.setString(2,userBean.getPassword());
            ps.setString(3,userBean.getRename());
            ps.setString(4,userBean.getSex());
            ps.setInt(5,userBean.getAge());
            ps.setString(6,userBean.getBirth());
            ps.setString(7,userBean.getIDnumber());
            ps.setInt(8,userBean.getIsRemove());

            int i = ps.executeUpdate();
            return (i!=0)?1:0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteData(UserBean userBean) {
        return 0;
    }

    @Override
    public int updateData(UserBean userBean) {
        return 0;
    }

    @Override
    public List<UserBean> selectData(UserBean userBean) {
        return null;
    }

    @Override
    public UserBean selectOne(UserBean userBean) {
        try {
            String sql_select = "select uname,password from userinfo where uname='"+userBean.getUname()+"' and password='"+userBean.getPassword()+"'";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql_select);
            UserBean user = new UserBean();
            while(rs.next()){
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
