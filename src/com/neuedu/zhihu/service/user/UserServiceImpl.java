package com.neuedu.zhihu.service.user;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.dao.IBaseDao;
import com.neuedu.zhihu.dao.user.UserDaoImpl;
import com.neuedu.zhihu.service.IUserService;

import java.sql.SQLException;
import java.util.List;

import static com.neuedu.zhihu.util.MD5Util.getMD5;

public class UserServiceImpl implements IUserService {   //实现类加Impl
    //实例一个对象，调用这个对象的方法
    private IBaseDao<UserBean> userdao = UserDaoImpl.getUserDao();
    //单例模式
    private static UserServiceImpl userService;
    private UserServiceImpl(){}
    public static UserServiceImpl getUserService(){
        if (userService==null){        //先判断是否加锁
            synchronized (UserServiceImpl.class){  //对本类加锁
                if (userService==null)
                    userService = new UserServiceImpl();
            }
        }
        return userService;
    }

    //数据处理，判断是否符合入库要求以及业务逻
    int isRemove = 0;
    @Override
    public int insertInfo(UserBean userBean) {
        //数据判断，用户名是否重复，性别：0：女、1：男
       // if (userBean.getId_card().equals())
        if("男".equals(userBean.getSex())){
            userBean.setSqlsex(1);
        }else{
            userBean.setSqlsex(0);
        }
        //与dao层连接，判断数据库是否操作成功
        int flg = userdao.insertData(userBean);
        if (flg!=0)
            return 1;//成功
        else
            return 0;//失败
    }

    @Override
    public int deleteInfo(UserBean userBean) {
        return 0;
    }

    @Override
    public int updateInfo(UserBean userBean) {
        return 0;
    }

    @Override
    public List<UserBean> selectInfo(UserBean userBean) {
        return null;
    }

    @Override
    public UserBean selectOne(UserBean userBean) {
        //获取用户id
        //调用dao的查询数据
        //select u.id,u.uname,Idcard,u.phone,p.path from userinfo u,photos p where u.photoId = p.Id and u.id = ?
       String phone = "18181886261";
        userBean.setPassword(null);
        userBean.setPhone(phone.substring(0,3)+"****"+phone.substring(7));
        userBean.setId_card("*************7898");
        userBean.setPath("/");
        userBean.setUname("zhangsan");
        userBean.setSex("男");
        return userBean;
    }

    @Override
    public UserBean login(UserBean userBean) throws SQLException {
        UserBean oldData = userBean;  //保存没加密的密码
        userBean.setPassword(getMD5(userBean.getPassword()));  //对没加密的密码进行加密处理
        //对登录密码进行MD5加密处理
        //用加密后的密码进行数据库查询
        userBean = userdao.selectOne(userBean);
        //判断是否查到
        if (userBean == null){  //如果没有查询到,就用原始密码查询
            userBean = userdao.selectOne(oldData);
            if (userBean == null){
                return null;
            }else {    //用原始密码查询到了,就对原始密码进行加密
                oldData.setPassword(getMD5(oldData.getPassword()));
                UserBean finalData = oldData;
                new Thread(() -> {   //开启多线程,对原始密码加密后的密码进行入库处理
                    userdao.updateData(finalData);
                }).start();
                return  oldData;
            }
        }else
            return userBean;
    }
}
