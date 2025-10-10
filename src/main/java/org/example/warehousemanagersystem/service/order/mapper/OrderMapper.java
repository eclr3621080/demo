package org.example.warehousemanagersystem.service.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.bo.OrderUpdateBO;
import org.example.warehousemanagersystem.service.order.pojo.OrderPOJO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;

import java.util.List;
@Mapper
public interface OrderMapper {
    List<OrderGetVO> getList(OrderGetBO orderGetBO);

    OrderGetVO getOne(OrderGetBO orderGetBO);

    Integer updateOrder(OrderUpdateBO orderUpdateBO);

    Long getLong(OrderGetBO orderGetBO);

    void addOrder(OrderPOJO orderPOJO);
}
