package org.example.warehousemanagersystem.service.customer.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.*;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

public interface CustomerService {
    void add(CustomerAddBO customerAddBO);
    RetStatus<Object> update(CustomerUpdateBO customerUpdateBO);
    RetStatus<Object> delete(CustomerDeleteBO customerDeleteBO);
    List<CustomerVO> getList(CustomerGetBO customerGetBO);
    CustomerVO getOne (CustomerGetBO customerGetBO);


    Long getLong(CustomerGetBO customerGetBO);

    RetStatus<Object> login(CustomerLoginBO customerLoginBO);
}
