package org.example.warehousemanagersystem.service.order.pojo;

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
     private String orderStatus;
     private String account;
     private String orderPayName;
     private String orderGoods;
     private Integer isDelete;
     private String remark;
}
