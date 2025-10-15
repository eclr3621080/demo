package org.example.warehousemanagersystem.service.order.pojo;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.Setter;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import javax.swing.*;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Setter
@Getter
public class OrderPOJO extends BaseFlagPOJO {
     private String createTime;
     private String updateTime;
     private String orderNo;
     private String orderPrice;
     private Integer orderStatus;
     private String account;
     private Integer orderPayCustomerId;
     private String orderPayName;
     private String orderAddress;
     private Long orderMobile;
     private String orderGoods;
     private Integer isDelete;
     private String remark;
    private Integer peiwanId;
    private Integer orderPayType;
    private  Integer orderGameTypeId;
    private  Integer orderNumber;
    private Integer customerId;
}
