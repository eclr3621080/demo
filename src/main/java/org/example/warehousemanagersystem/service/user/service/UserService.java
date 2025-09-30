package org.example.warehousemanagersystem.service.user.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.bo.*;

import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */


public interface UserService {
   void  add(UserAddBO userAddBO);
    List<UserGetVO> list(UserGetBO userGetBO);
    UserGetVO getone(UserGetBO userGetBO);
    RetStatus<Object> login(UserLoginBO userGetBO);
    RetStatus<Object> update(UserUpdateBO userUpdateBO);


    RetStatus<Object> delete(UserDeleteBO userDeleteBO);

    RetStatus<Object> logout(UserLoginBO userLoginBO);
}
