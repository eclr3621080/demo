package org.example.warehousemanagersystem.service.role.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.bo.RoleGetBO;
import org.example.warehousemanagersystem.service.role.bo.RoleUpdateBO;
import org.example.warehousemanagersystem.service.role.mapper.RoleMapper;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;
import org.example.warehousemanagersystem.service.role.service.RoleService;
import org.example.warehousemanagersystem.service.role.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Override
    @Transactional
    public void addRole(RolePOJO rolePOJO) {
        roleMapper.add(rolePOJO);
    }

    @Override
    @Transactional
    public RetStatus<Object> deleteRole(RoleDeleteBO roleDeleteBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (roleDeleteBO.getId()==null ||  roleDeleteBO.getId()<=0) {
            retStatus.set(-1,"数据异常");
        }
        roleMapper.delete(roleDeleteBO);
        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> updateRole(RoleUpdateBO roleUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (roleUpdateBO.getId()==null ||  roleUpdateBO.getId()<=0) {
            retStatus.set(-1,"数据异常");
        }
        Integer update = roleMapper.update(roleUpdateBO);
        if (update != 1) {
            retStatus.set(-1,"修改失败");
        }
        return retStatus;
    }

    @Override
    public List<RoleVO> getRoleList(RoleGetBO roleGetBO) {

        if (roleGetBO.getId()==null ||  roleGetBO.getId()<=0) {
          return new ArrayList<>();
        }
        List<RoleVO> list= roleMapper.getList(roleGetBO);
        return list;
    }

    @Override
    public RoleVO getRoleOne(RoleGetBO roleGetBO) {

        if (roleGetBO.getId()==null ||  roleGetBO.getId()<=0) {
            return   new RoleVO();
        }
        RoleVO roleVO= roleMapper.getOne(roleGetBO);
        return roleVO;
    }
}
