package org.example.warehousemanagersystem.service.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.customer.bo.CustomerAddBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerDeleteBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerUpdateBO;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void add(CustomerAddBO customerAddBO);

    Integer update(CustomerUpdateBO customerUpdateBO);

    void delete(CustomerDeleteBO roleDeleteBO);

    List<CustomerVO> getList(CustomerGetBO customerGetBO);

    CustomerVO getOne(CustomerGetBO customerGetBO);

    Long getLong(CustomerGetBO customerGetBO);
}
