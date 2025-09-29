package org.example.warehousemanagersystem.service.user.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

@Mapper
public interface UserTestMapper {
    void addUser(UserPOJO userPOJO);

    List<UserGetVO> listUser(UserGetBO userGetBO);

    UserGetVO getOne(UserGetBO userGetBO);
}
