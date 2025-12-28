package org.example.warehousemanagersystem.service.customer.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.customer.pojo.CustomerPOJO;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Data
public class CustomerVO extends CustomerPOJO {
    private String token;
}