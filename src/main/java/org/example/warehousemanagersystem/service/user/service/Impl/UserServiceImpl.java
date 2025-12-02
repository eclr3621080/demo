package org.example.warehousemanagersystem.service.user.service.Impl;

import cn.dev33.satoken.stp.StpUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.*;


import org.example.warehousemanagersystem.service.user.mapper.UserTestMapper;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    @Transactional(rollbackFor = Exception.class)
    public void add(UserAddBO userAddBO) {
        StpUtil.checkLogin();
        UserPOJO userPOJO = new UserPOJO();
        BeanUtils.copyProperties(userAddBO,userPOJO);
        if (userAddBO.getUserAvatar()!=null){
            RetStatus jsonObject = JSONObject.parseObject(userAddBO.getUserAvatar(),RetStatus.class);
            userPOJO.setUserAvatar((String) jsonObject.getData());
        }
        userTestMapper.addUser(userPOJO);
    }

    @Override
    public List<UserGetVO> list(UserGetBO userGetBO) {
        try {
            if (!CollectionUtils.isEmpty(userGetBO.getCreateTimeRange())){
                long milliseconds = userGetBO.getCreateTimeRange().get(0);
                long milliseconds1 = userGetBO.getCreateTimeRange().get(1);

                Instant instant = Instant.ofEpochMilli(milliseconds);
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Instant instant1 = Instant.ofEpochMilli(milliseconds1);
                LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());

                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDate = localDateTime.format(formatter);
                String formattedDate1 = localDateTime1.format(formatter1);
                userGetBO.setCreateTimeEnd(formattedDate1);
                userGetBO.setCreateTimeStart(formattedDate);
            }
            return userTestMapper.listUser(userGetBO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserGetVO getone(UserGetBO userGetBO) {
        return userTestMapper.getOne(userGetBO);
    }

    @Override
    public RetStatus<Object> login(UserLoginBO userLoginBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO = new UserGetBO();
            userGetBO.setUserName(userLoginBO.getUserName());
            UserGetVO userGetVOList = userTestMapper.getOne(userGetBO);
            if (userGetVOList == null || userGetVOList.getId() <= 0) {
                retStatus.set("-1", "没有该账号");
            }
            if (!userGetVOList.getPassWord().equals(userLoginBO.getPassword())) {
                retStatus.set("-1", "密码错误");
            }
            StpUtil.login(userGetVOList.getId());
            StpUtil.isLogin();
            userGetVOList.setToken(StpUtil.getTokenValue());
            retStatus.setData(userGetVOList);

        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set("-1", e.getMessage());
        }
        return retStatus;
    }

    @Override
    public RetStatus<Object> logout(UserLoginBO userLoginBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            UserGetBO userGetBO = new UserGetBO();
            userGetBO.setEmployeeNo(userLoginBO.getUserName());
            UserGetVO userGetVOList = userTestMapper.getOne(userGetBO);
            if (userGetVOList == null || userGetVOList.getId() <= 0) {
                retStatus.set("-1", "没有该账号");
            }
            StpUtil.logout(userLoginBO.getUserName());
            retStatus.setData(StpUtil.getTokenInfo());
        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set("-1", e.getMessage());
        }
        return retStatus;
    }

    @Override
    public Long getLong(UserGetBO userGetBO) {
        Long total= userTestMapper.getLong(userGetBO);
        return total;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(UserUpdateBO userUpdateBO) throws IOException {
        RetStatus<Object> retStatus = new RetStatus<>();

      if (userUpdateBO.getUserAvatar()!=null){
          RetStatus jsonObject = JSONObject.parseObject(userUpdateBO.getUserAvatar(),RetStatus.class);
          userUpdateBO.setImg((String) jsonObject.getData());
          userUpdateBO.setUserAvatar((String) jsonObject.getData());
      }


        if (CollectionUtils.isEmpty(userUpdateBO.getIds()) && !ObjectUtils.isEmpty(userUpdateBO.getId())) {
            Set<Integer> ids = new HashSet<>();
            ids.add(userUpdateBO.getId());
            userUpdateBO.setIds(ids);
        }
        Integer i = userTestMapper.updateUser(userUpdateBO);
        if (i != 1) {
            retStatus.set("-1", "更新失败");
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
            retStatus.set("-1", "登录账号错误");
            return retStatus;
        }
        if (userDeleteBO.getId().equals(id)) {
            retStatus.set("-1", "无法删除自己的账号");
            return retStatus;
        }
        UserGetBO userGetBO = new UserGetBO();
        userGetBO.setId(userDeleteBO.getId());
        UserGetVO one = userTestMapper.getOne(userGetBO);
        if (one == null) {
            retStatus.set("-1", "删除错误");
            return retStatus;
        }
        if (one.getRoleId().equals(1)) {
            retStatus.set("-1", "无法删除超级管理员");
            return retStatus;
        }

        UserUpdateBO userUpdateBO = new UserUpdateBO();
        Set<Integer> integers = new HashSet<>();
        integers.add(userDeleteBO.getId());
        userUpdateBO.setIds(integers);
        userUpdateBO.setIsDelete(1);
        Integer i = userTestMapper.updateUser(userUpdateBO);
        if (i != 1) {
            retStatus.set("-1", "更新失败");
        }
        return retStatus;
    }


}
