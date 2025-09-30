package org.example.warehousemanagersystem.service.customer.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.CustomerAddBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerUpdateBO;
import org.example.warehousemanagersystem.service.role.bo.RoleDeleteBO;
import org.example.warehousemanagersystem.service.role.pojo.RolePOJO;

public interface CustomerService {
    void add(CustomerAddBO customerAddBO);
    RetStatus<Object> update(CustomerUpdateBO customerUpdateBO);
    RetStatus<Object> delete(RoleDeleteBO roleDeleteBO);
    List<>

}
