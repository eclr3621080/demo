package org.example.warehousemanagersystem.service.user.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.*;


import org.example.warehousemanagersystem.service.user.mapper.UserTestMapper;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (!"1".equals(userGetBO.getEmployeeNo())) {
            return new ArrayList<>();
        }
        return userTestMapper.listUser(userGetBO);
    }

    @Override
    public UserGetVO getone(UserGetBO userGetBO) {


        if (!"1".equals(userGetBO.getEmployeeNo())) {
            return new UserGetVO();
        }
        return userTestMapper.getOne(userGetBO);
    }

    @Override
    public RetStatus<Object> login(UserLoginBO userLoginBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO = new UserGetBO();
            userGetBO.setEmployeeNo(userLoginBO.getEmployeeNo());
            UserGetVO userGetVOList = userTestMapper.getOne(userGetBO);
            if (userGetVOList == null || userGetVOList.getId() <= 0) {
                retStatus.set(-1, "没有该账号");
            }
            if (!userGetVOList.getSecret().equals(userLoginBO.getSecret())) {
                retStatus.set(-1, "密码错误");
            }
            StpUtil.login(userLoginBO.getEmployeeNo());
            StpUtil.isLogin();
            userGetVOList.setToken(StpUtil.getTokenValue());
            retStatus.setData(userGetVOList);

        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set(-1, e.getMessage());
        }
        return retStatus;
    }

    @Override
    public RetStatus<Object> logout(UserLoginBO userLoginBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO = new UserGetBO();
            userGetBO.setEmployeeNo(userLoginBO.getEmployeeNo());
            UserGetVO userGetVOList = userTestMapper.getOne(userGetBO);
            if (userGetVOList == null || userGetVOList.getId() <= 0) {
                retStatus.set(-1, "没有该账号");
            }
            StpUtil.logout(userLoginBO.getEmployeeNo());
            retStatus.setData(StpUtil.getTokenInfo());
        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set(-1, e.getMessage());
        }
        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(UserUpdateBO userUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (CollectionUtils.isEmpty(userUpdateBO.getIds()) && !ObjectUtils.isEmpty(userUpdateBO.getId())) {
            Set<Integer> ids = userUpdateBO.getIds();
            ids.add(userUpdateBO.getId());
            userUpdateBO.setIds(ids);
        }
        Integer i = userTestMapper.updateUser(userUpdateBO);
        if (i != 1) {
            retStatus.set(-1, "更新失败");
        }
        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> delete(UserDeleteBO userDeleteBO) {
        Object loginId = StpUtil.getLoginId();
        Integer id = Integer.valueOf((String) loginId);
        RetStatus<Object> retStatus = new RetStatus<>();
        if (loginId == null) {
            retStatus.set(-1, "登录账号错误");
            return retStatus;
        }
        UserGetBO userGetBO = new UserGetBO();
        userGetBO.setId(id);
        UserGetVO one = userTestMapper.getOne(userGetBO);
        if (one == null) {
            retStatus.set(-1, "登录账号错误");
            return retStatus;
        }
        if (!"1".equals(one.getEmployeeNo())) {
            retStatus.set(-1, "登录账号没权限");
            return retStatus;
        }
        if (one.getId() == userDeleteBO.getId()) {
            retStatus.set(-1, "不能自己删除自己");
            return retStatus;
        }
        UserUpdateBO userUpdateBO = new UserUpdateBO();
        Set<Integer> integers = new HashSet<>();
        integers.add(userDeleteBO.getId());
        userUpdateBO.setIds(integers);
        userUpdateBO.setIsDelete(1);
        Integer i = userTestMapper.updateUser(userUpdateBO);
        if (i != 1) {
            retStatus.set(-1, "更新失败");
        }
        return retStatus;
    }


}
