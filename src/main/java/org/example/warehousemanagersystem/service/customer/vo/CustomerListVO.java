package org.example.warehousemanagersystem.service.customer.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Data
public class CustomerListVO {
    private List<CustomerVO> records;
    private Long total;
}
