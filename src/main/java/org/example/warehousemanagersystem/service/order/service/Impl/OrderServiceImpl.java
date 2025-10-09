package org.example.warehousemanagersystem.service.order.service.Impl;

import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.mapper.OrderMapper;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<OrderGetVO> list(OrderGetBO orderGetBO) {
    List<OrderGetVO>  list   =orderMapper.getList(orderGetBO);
    return list;
    }
}
