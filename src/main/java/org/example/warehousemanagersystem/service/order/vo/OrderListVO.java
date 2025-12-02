package org.example.warehousemanagersystem.service.order.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Data
public class OrderListVO {
    private List<OrderGetVO> records;
    private Long total;
}
