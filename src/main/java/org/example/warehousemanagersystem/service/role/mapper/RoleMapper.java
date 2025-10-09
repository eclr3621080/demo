package org.example.warehousemanagersystem.service.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.bo.RoleGetBO;
import org.example.warehousemanagersystem.service.role.bo.RoleUpdateBO;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;
import org.example.warehousemanagersystem.service.role.vo.RoleVO;

import java.util.List;

@Mapper
public interface RoleMapper {
    void add(RolePOJO rolePOJO);

    void delete(RoleDeleteBO roleDeleteBO);

    Integer update(RoleUpdateBO roleUpdateBO);

    List<RoleVO> getList(RoleGetBO roleGetBO);

    RoleVO getOne(RoleGetBO roleGetBO);
}
