package org.gemusi.system.dao;

import org.gemusi.system.model.UserInfo;
import org.gemusi.system.vo.UserVo;

import java.util.List;

public interface UserInfoMapper{
    /**
     * 查询用户列表数据
     * @param userInfo
     * @return
     */
    List<UserVo> selectTable(UserInfo userInfo);

    /**
     * 查找用户列表数据数量
     * @param userInfo
     * @return
     */
    long selectTableCount(UserInfo userInfo);

    UserInfo selectByUserid(String userid);
}