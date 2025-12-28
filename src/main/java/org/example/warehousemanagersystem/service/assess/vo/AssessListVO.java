package org.example.warehousemanagersystem.service.assess.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Data
public class AssessListVO {
    private List<AssessGetVO> records;
    private Long total;
}
