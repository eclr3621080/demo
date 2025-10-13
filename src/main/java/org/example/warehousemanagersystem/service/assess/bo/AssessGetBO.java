package org.example.warehousemanagersystem.service.assess.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;
import org.example.warehousemanagersystem.service.assess.pojo.AssessPOJO;

import java.math.BigDecimal;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Data
public class AssessGetBO extends BaseGetBO {
    private Integer id;
    private Integer current;
    private Integer size;
    private Integer peiwanId;
    private Integer orderId;
    private String assessment;
    private BigDecimal star;
    private BigDecimal tips;
    private Integer isTip;
    private String createTime;
    private String updateTime;
    private Integer isDelete;
}
