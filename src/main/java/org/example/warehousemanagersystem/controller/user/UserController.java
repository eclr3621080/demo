package org.example.warehousemanagersystem.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.order.vo.OrderListVO;
import org.example.warehousemanagersystem.service.role.bo.RoleGetBO;
import org.example.warehousemanagersystem.service.role.service.RoleService;
import org.example.warehousemanagersystem.service.role.vo.RoleVO;
import org.example.warehousemanagersystem.service.user.bo.*;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.example.warehousemanagersystem.service.user.vo.UserListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    @ResponseBody
    public String addUser(@RequestBody  UserAddBO userAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            userService.add(userAddBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }

    @PutMapping("/{id}/status")
    @ResponseBody
    public String statusUser(@PathVariable  Integer id){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO=new UserGetBO();
            userGetBO.setId(id);
            UserGetVO getone = userService.getone(userGetBO);
            UserUpdateBO userUpdateBO=new UserUpdateBO();
            userUpdateBO.setId(getone.getId());
            userUpdateBO.setStatus((getone.getStatus()+1)%2);
            userService.update(userUpdateBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/list")
    @ResponseBody
    public String listUser(@RequestBody UserGetBO userGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            userGetBO.setPage(userGetBO.getCurrent());
            userGetBO.setLimit(userGetBO.getSize());
            List<UserGetVO> list = userService.list(userGetBO);
            UserListVO userListVO = new UserListVO();
            userListVO.setRecords(list);
            Long ordertotal =userService.getLong(userGetBO);
            userListVO.setTotal(ordertotal);
            retStatus.setData(userListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @GetMapping("{id}")
    @ResponseBody
    public String infoUser(@PathVariable Integer id){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            UserGetBO userGetBO=new UserGetBO();
            userGetBO.setId(id);
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
    @PostMapping("/logoutuser")
    @ResponseBody
    public String logout(@RequestBody UserLoginBO userLoginBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            retStatus= userService.logout(userLoginBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
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
            retStatus.set("-1", e.getMessage());
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
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/delete")
    @ResponseBody
    public String deleteUser(@RequestBody UserDeleteBO userDeleteBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = userService.delete(userDeleteBO);
        } catch (Exception e) {
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }

    @GetMapping("/roles")
    @ResponseBody
    public String rolesUser(){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            String userName = (String)StpUtil.getLoginId();
            UserGetBO userGetBO=new UserGetBO();
            userGetBO.setUserName(userName);
            UserGetVO getone = userService.getone(userGetBO);
            RoleGetBO roleGetBO=new RoleGetBO();
            roleGetBO.setUserId(getone.getId());
            RoleVO roleOne = roleService.getRoleOne(roleGetBO);
            retStatus.setData(roleOne);
        } catch (Exception e) {
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }




}
