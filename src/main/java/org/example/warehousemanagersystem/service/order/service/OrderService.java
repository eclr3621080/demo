package org.example.warehousemanagersystem.service.order.service;

import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    List<OrderGetVO> list(OrderGetBO orderGetBO);
}
