package org.example.warehousemanagersystem.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.*;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("api/user")
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

    @PostMapping("/list")
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
    @PostMapping("/infouser")
    @ResponseBody
    public String infoUser(@RequestBody UserGetBO userGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            UserGetVO list = userService.getone(userGetBO);
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(list.getRoleId());
            list.setRoles(integers);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/login")
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
    @PostMapping("/logoutuser")
    @ResponseBody
    public String logout(@RequestBody UserLoginBO userLoginBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            retStatus= userService.logout(userLoginBO);

        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }


    @PostMapping("/loginisorno")
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
    @PostMapping("/updateuser")
    @ResponseBody
    public String updateuser(@RequestBody UserUpdateBO updateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = userService.update(updateBO);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/deleteuser")
    @ResponseBody
    public String deleteUser(@RequestBody UserDeleteBO userDeleteBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = userService.delete(userDeleteBO);
        } catch (Exception e) {
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }






}
