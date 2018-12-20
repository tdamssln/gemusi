package org.gemusi.system.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.gemusi.common.json.JsonResult;
import org.gemusi.common.util.AppHelper;
import org.gemusi.system.dao.UserInfoMapper;
import org.gemusi.system.dto.UserDto;
import org.gemusi.system.model.UserInfo;
import org.gemusi.system.service.UserInfoService;
import org.gemusi.system.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public JsonResult getTable(UserDto userDto) {
        JsonResult json = new JsonResult();
        try {
            log.info("查询用户列表参数是：{}", JSON.toJSON(userDto).toString());
            PageHelper.startPage(userDto.getPage(), userDto.getRows());
            List<UserVo> list=userInfoMapper.selectTable(userDto.getUserInfo());
            json.setSuccess(true)
                    .setRows(list)
                    .setTotal(list.size());
            //        userInfoMapper.selectTableCount(userDto.getUserInfo());
            log.info(list.size()+"");
            log.info("查询用户列表成功！");

        } catch (Exception e) {
            log.error("查询列表失败：{}", e);
        }
        return json;
    }

    @Override
    public JsonResult save(UserInfo userInfo) {
        JsonResult json = new JsonResult();
       /* try {
            log.info("保存用户信息，userinfo：{}", userInfo);
            if(userInfo.getId()!=null){
                userInfoMapper.updateByPrimaryKey(userInfo);
            }else {
                userInfo.setId(AppHelper.getUUID());
                userInfoMapper.insert(userInfo);
            }
            json.setSuccess(true).setMessage("用户信息保存成功！");
            log.info("查询用户信息成功！");
        } catch (Exception e) {
            log.error("用户保存失败：{}", e);
        }*/
        return json;
    }

    @Override
    public void initEdit(String userid, ModelMap map) {
        map.put("user",userInfoMapper.selectByUserid(userid));
    }

    @Override
    public JsonResult del(String id) {
        JsonResult json = new JsonResult();
       /* try {
            json.setSuccess(true).setRows(userInfoMapper.deleteByPrimaryKey(id));
            log.info("用户删除成功！");

        } catch (Exception e) {
            log.error("用户删除失败：{}", e);
        }*/
        return json;
    }

    @Override
    public JsonResult editPassword(String userId, String password) {
        return null;
    }

    @Override
    public JsonResult findByUserid(String userid) {
        JsonResult json = new JsonResult();
        try {
            log.info("查询用户信息，userid：{}", userid);
            json.setSuccess(true).setRows(userInfoMapper.selectByUserid(userid));
            log.info("查询用户信息成功！");

        } catch (Exception e) {
            log.error("查询用户信息失败：{}", e);
        }
        return json;
    }
}
