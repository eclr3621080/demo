package org.example.warehousemanagersystem.controller.auth;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserLoginBO userLoginBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            retStatus= userService.login(userLoginBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @GetMapping("getUserInfo")
    @ResponseBody
    public String infoUser(){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            String loginId = (String)StpUtil.getLoginId();
            UserGetBO userGetBO=new UserGetBO();
           userGetBO.setUserName(loginId);
            UserGetVO list = userService.getone(userGetBO);
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(list.getRoleId());
            list.setRoles(integers);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
}
