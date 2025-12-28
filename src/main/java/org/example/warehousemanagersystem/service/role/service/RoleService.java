package org.example.warehousemanagersystem.service.role.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.bo.RoleGetBO;
import org.example.warehousemanagersystem.service.role.bo.RoleUpdateBO;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;
import org.example.warehousemanagersystem.service.role.vo.RoleVO;

import java.util.List;

public interface RoleService {
    void addRole(RolePOJO rolePOJO);
    RetStatus<Object> deleteRole(RoleDeleteBO roleDeleteBO);
    RetStatus<Object> updateRole(RoleUpdateBO roleUpdateBO);
    List<RoleVO> getRoleList(RoleGetBO roleGetBO);
    RoleVO getRoleOne(RoleGetBO roleGetBO);
}
