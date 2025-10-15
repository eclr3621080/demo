package org.example.warehousemanagersystem.service.customer.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Data
public class CustomerGetBO extends BaseGetBO {
    private Integer id;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 客户账号
     */
    private  String account;
    /**
     * 头像
     */
    private String customerProfile;


    private  String passWord;
    private String idCard;
    private String name;
    private Integer sex;
    private Integer buyNumber;
    private String remark;
    private Integer status;
    private String vipDate;
    private BigDecimal vipDiscount;
    private String isVip;

    private Integer current;
    private Integer size;

}
