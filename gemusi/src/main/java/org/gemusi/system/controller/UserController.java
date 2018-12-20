package org.gemusi.system.controller;

import org.gemusi.common.json.JsonResult;
import org.gemusi.system.dto.UserDto;
import org.gemusi.system.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public String init(ModelMap map) {
        return "system/user/user";
    }

    @RequestMapping("getTable")
    @ResponseBody
    public JsonResult getList(UserDto userDto){
        return userInfoService.getTable(userDto);
    }

    @RequestMapping("toAdd")
    public String toAdd(ModelMap map) {
        return "userAdd.ftl_bak";
    }
}
