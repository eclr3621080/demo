package org.example.warehousemanagersystem.service.user.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Data
public class UserListVO {
    private List<UserGetVO> records;
    private Long total;
}
