package org.example.warehousemanagersystem.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.UserAddBO;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping("/adduser")
    @ResponseBody
    public String addUser(@RequestBody  UserAddBO userAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            userService.add(userAddBO);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }

    @PostMapping("/listuser")
    @ResponseBody
    public String listUser(@RequestBody UserGetBO userGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            List<UserGetVO> list = userService.list(userGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/loginuser")
    @ResponseBody
    public String login(@RequestBody UserLoginBO userLoginBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            retStatus= userService.login(userLoginBO);

        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @RequestMapping("/loginisorno")
    @ResponseBody
    public String loginisno(){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus.setData( StpUtil.isLogin());
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }


}
