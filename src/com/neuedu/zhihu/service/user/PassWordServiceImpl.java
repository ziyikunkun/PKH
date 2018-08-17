package com.neuedu.zhihu.service.user;

import com.neuedu.zhihu.bean.UpdatePassBean;
import com.neuedu.zhihu.dao.IBaseDao;
import com.neuedu.zhihu.dao.user.PassWordDaoImpl;
import com.neuedu.zhihu.common.IBaseService;

import java.sql.SQLException;
import java.util.List;

import static com.neuedu.zhihu.util.MD5Util.getMD5;

public class PassWordServiceImpl implements IBaseService<UpdatePassBean> {

    IBaseDao<UpdatePassBean> passDao = PassWordDaoImpl.getPassword();
    @Override
    public int insertInfo(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int deleteInfo(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int updateInfo(UpdatePassBean updatePassBean) throws SQLException {

    updatePassBean.setOldPass(getMD5(updatePassBean.getOldPass()));  //对老密码进行加密处理
    UpdatePassBean oldPass = passDao.selectOne(updatePassBean);  //根据老密码查询该用户是否存在
    if (oldPass.getId() !=null && !"".equals(oldPass.getId())){
        updatePassBean.setId(oldPass.getId());  //设置密码的id
        updatePassBean.setNewPass(getMD5(updatePassBean.getNewPass()));  //设置新密码，并进行加密处理
        int i = passDao.updateData(updatePassBean);  //数据库操作
        return i; //返回给servlet
    }

        return 0;
    }

    @Override
    public List selectInfo(UpdatePassBean updatePassBean) {
        return null;
    }

    @Override
    public UpdatePassBean selectOne(UpdatePassBean updatePassBean) {
        return null;
    }
}
