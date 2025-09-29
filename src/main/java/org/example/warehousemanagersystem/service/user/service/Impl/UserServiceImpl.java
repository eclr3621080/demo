package org.example.warehousemanagersystem.service.user.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.UserAddBO;


import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.example.warehousemanagersystem.service.user.mapper.UserTestMapper;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserTestMapper userTestMapper;

    @Override
    public void add(UserAddBO userAddBO) {
//        StpUtil.checkLogin();
        UserPOJO userPOJO = new UserPOJO();
        userPOJO.setAddTime(userAddBO.getF_add_time());
        userPOJO.setEmployeeNo(userAddBO.getF_employee_no());
        userPOJO.setUserAvatar(userAddBO.getF_user_avatar());
        userPOJO.setSecret(userAddBO.getF_secret());
        userPOJO.setUserName(userAddBO.getF_user_name());
        userPOJO.setSex(userAddBO.getF_sex());
        userPOJO.setAge(userAddBO.getF_age());
        userPOJO.setMobile(userAddBO.getF_mobile());
        userPOJO.setRemark(userAddBO.getF_remark());
        userTestMapper.addUser(userPOJO);
    }

    @Override
    public List<UserGetVO> list(UserGetBO userGetBO) {

        if (StpUtil.isLogin()) {
            return new ArrayList<>();
        }
        if (!"1".equals(userGetBO.getF_employee_no())) {
       return new ArrayList<>();
        }
        return userTestMapper.listUser(userGetBO);
    }
    @Override
    public UserGetVO getone(UserGetBO userGetBO) {


        if (!"1".equals(userGetBO.getF_employee_no())) {
            return new UserGetVO();
        }
        return userTestMapper.getOne(userGetBO);
    }
    @Override
    public RetStatus<Object> login(UserLoginBO userLoginBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO = new UserGetBO();
            userGetBO.setF_employee_no(userLoginBO.getEmployeeNo());
            UserGetVO userGetVOList = userTestMapper.getOne(userGetBO);
            if (userGetVOList == null || userGetVOList.getId() <= 0) {
                retStatus.set(-1, "没有该账号");
            }
            if (!userGetVOList.getSecret().equals(userLoginBO.getSecret())) {
                retStatus.set(-1, "密码错误");
            }
              StpUtil.login(userLoginBO.getEmployeeNo());
            retStatus.setData(StpUtil.getTokenInfo());

        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set(-1, e.getMessage());
        }
        return retStatus;
    }
}
