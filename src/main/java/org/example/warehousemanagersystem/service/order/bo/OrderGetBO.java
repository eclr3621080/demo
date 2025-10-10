package org.example.warehousemanagersystem.service.order.bo;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;
import org.example.warehousemanagersystem.service.order.pojo.OrderPOJO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Data
public class OrderGetBO extends BaseGetBO {
    private Integer id;
    private String createTime;
    private String updateTime;
    private String orderNo;
    private String orderPrice;
    private Integer orderStatus;
    private String account;
    private String orderPayName;
    private String orderGoods;
    private Integer isDelete;
    private String remark;
    private List<Long> createTimeRange;
    private String createTimeStart;
    private String createTimeEnd;
    private Integer current;
    private Integer size;

}
