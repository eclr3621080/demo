package org.example.warehousemanagersystem.service.customer.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.*;
import org.example.warehousemanagersystem.service.customer.mapper.CustomerMapper;
import org.example.warehousemanagersystem.service.customer.pojo.CustomerPOJO;
import org.example.warehousemanagersystem.service.customer.service.CustomerService;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    @Transactional
    public void add(CustomerAddBO customerAddBO) {
        CustomerPOJO customerPOJO = new CustomerPOJO();
        BeanUtils.copyProperties(customerAddBO,customerPOJO);
        customerMapper.add(customerPOJO);
    }

    @Override
    @Transactional
    public RetStatus<Object> update(CustomerUpdateBO customerUpdateBO) {
        RetStatus<Object>  retStatus = new RetStatus<>();
        if ( customerUpdateBO.getId()<=0){
            retStatus.set("-1","数据异常");
            return retStatus;
        }
       Integer i= customerMapper.update(customerUpdateBO);
        if (i!=1){
            retStatus.set("-1","数据更新失败");
        }
        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> delete(CustomerDeleteBO roleDeleteBO) {
        RetStatus<Object>  retStatus = new RetStatus<>();
        if (roleDeleteBO.getId()==null || roleDeleteBO.getId()<=0){
            retStatus.set("-1","数据异常");
            return retStatus;
        }
        customerMapper.delete(roleDeleteBO);
        return retStatus;
    }

    @Override
    public List<CustomerVO> getList(CustomerGetBO customerGetBO) {
        List<CustomerVO> list=  customerMapper.getList(customerGetBO);
        return list;
    }

    @Override
    public CustomerVO getOne(CustomerGetBO customerGetBO) {
       CustomerVO vo=  customerMapper.getOne(customerGetBO);
       return vo;
    }

    @Override
    public Long getLong(CustomerGetBO customerGetBO) {
        Long total= customerMapper.getLong(customerGetBO);
        return total;
    }

    @Override
    public RetStatus<Object> login(CustomerLoginBO customerLoginBO) {
        RetStatus<Object>  retStatus = new RetStatus<>();
        CustomerGetBO customerGetBO=new CustomerGetBO();
        customerGetBO.setAccount(customerLoginBO.getAccount());
        CustomerVO one = customerMapper.getOne(customerGetBO);
        if (one==null){
            retStatus.set("-1","不存在改账号，请注册");
            return retStatus;
        }
        if (!one.getPassWord().equals(customerLoginBO.getPassWord())){
            retStatus.set("-1","密码错误");
            return retStatus;
        }
        StpUtil.login(customerLoginBO.getAccount());
        StpUtil.isLogin();
        one.setToken(StpUtil.getTokenValue());
        retStatus.setData(one);
        return   retStatus;
    }
}
