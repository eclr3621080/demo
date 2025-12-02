package org.example.warehousemanagersystem.service.peiwan.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class PeiWanListVO {
    private List<PeiWanGetVO> records;
    private Long total;
}
