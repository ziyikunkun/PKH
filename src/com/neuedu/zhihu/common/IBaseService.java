package com.neuedu.zhihu.common;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {    //接口名称前加I,使用泛型来规定类型
   //接口默认访问权限是Public

   static int isRemove = 0;
    //业务目标
    //增
    int insertInfo(T t);//注销用户，但是用户数据依然存在
    //删
    int deleteInfo(T t);
    //改
    int updateInfo(T t) throws SQLException;
    //查
    List<T> selectInfo(T t);
    //List<T> selectAll(T t);//查询全部
    T selectOne(T t);
}
