package org.example.warehousemanagersystem.service.order.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.bo.OrderUpdateBO;
import org.example.warehousemanagersystem.service.order.mapper.OrderMapper;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        try {
            if (!CollectionUtils.isEmpty(orderGetBO.getCreateTimeRange())){
                long milliseconds = orderGetBO.getCreateTimeRange().get(0);
                long milliseconds1 = orderGetBO.getCreateTimeRange().get(1);

                Instant instant = Instant.ofEpochMilli(milliseconds);
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Instant instant1 = Instant.ofEpochMilli(milliseconds1);
                LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());

                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDate = localDateTime.format(formatter);
                String formattedDate1 = localDateTime1.format(formatter1);
                orderGetBO.setCreateTimeEnd(formattedDate1);
                orderGetBO.setCreateTimeStart(formattedDate);
            }
            List<OrderGetVO>  list   =orderMapper.getList(orderGetBO);
            return list;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public OrderGetVO getone(OrderGetBO orderGetBO) {
        try {
            OrderGetVO  orderGetVO   =orderMapper.getOne(orderGetBO);
            return orderGetVO;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(OrderUpdateBO orderUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        Integer i =orderMapper.updateOrder(orderUpdateBO);
        if (i != 1) {
            retStatus.set("-1", "更新失败");
        }
        return retStatus;
    }

    @Override
    public Long getLong(OrderGetBO orderGetBO) {
       Long total= orderMapper.getLong(orderGetBO);
       return total;
    }
}
