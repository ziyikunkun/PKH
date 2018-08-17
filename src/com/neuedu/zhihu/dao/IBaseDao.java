package com.neuedu.zhihu.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * Created by pkh on 2018/8/8.
 */
public interface IBaseDao<T> {
   // 执行具体的sql语句，执行业务
    //增    sql语句
    int insertData(T t);
    //删
    int deleteData(T t);//此处删除只是将用户的isRemove改成1，即可
    //改
    int updateData(T t);
    //查
    List<T> selectData(T t);
    //List<T> selectAll(T t);//查询全部
    T selectOne(T t) throws SQLException;
}
