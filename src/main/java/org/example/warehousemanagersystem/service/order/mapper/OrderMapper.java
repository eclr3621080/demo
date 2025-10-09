package org.example.warehousemanagersystem.service.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;

import java.util.List;
@Mapper
public interface OrderMapper {
    List<OrderGetVO> getList(OrderGetBO orderGetBO);
}
