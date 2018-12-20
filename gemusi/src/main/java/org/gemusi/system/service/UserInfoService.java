package org.gemusi.system.service;

import org.gemusi.common.json.JsonResult;
import org.gemusi.system.dto.UserDto;
import org.gemusi.system.model.UserInfo;
import org.springframework.ui.ModelMap;

public interface UserInfoService {
    /**
     * 获取用户列表数据
     * @param userDto
     * @return
     */
    JsonResult getTable(UserDto userDto);

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    JsonResult save(UserInfo userInfo);

    /**
     * 初始化修改数据
     * @param id
     * @param map
     */
    void initEdit(String id, ModelMap map);

    /**
     * 根据id删除一条用户
     * @param id
     * @return
     */
    JsonResult del(String id);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    JsonResult editPassword(String userId, String password);

    /**
     * 根据userid查用户信息
     * @param userid
     * @return
     */
    public JsonResult findByUserid(String userid);

}
