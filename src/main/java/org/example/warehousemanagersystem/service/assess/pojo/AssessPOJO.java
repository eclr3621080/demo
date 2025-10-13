package org.example.warehousemanagersystem.service.assess.pojo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import java.math.BigDecimal;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Data
public class AssessPOJO extends BaseFlagPOJO {
    private Integer peiwanId;
    private Integer orderId;
    private String assessment;
    private BigDecimal star;
    private BigDecimal tips;
    private Integer isTip;
    private String createTime;
    private String updateTime;
    private  Integer isDelete;
}
