package org.example.warehousemanagersystem.service.customer.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.CustomerAddBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerDeleteBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerUpdateBO;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;

import java.util.List;

public interface CustomerService {
    void add(CustomerAddBO customerAddBO);
    RetStatus<Object> update(CustomerUpdateBO customerUpdateBO);
    RetStatus<Object> delete(CustomerDeleteBO customerDeleteBO);
    List<CustomerVO> getList(CustomerGetBO customerGetBO);
    CustomerVO getOne (CustomerGetBO customerGetBO);

}
