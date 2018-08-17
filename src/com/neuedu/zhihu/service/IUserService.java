package com.neuedu.zhihu.service;

import com.neuedu.zhihu.bean.UserBean;
import com.neuedu.zhihu.common.IBaseService;

import java.sql.SQLException;

public interface IUserService extends IBaseService<UserBean>{

    UserBean login(UserBean userBean) throws SQLException;
}
