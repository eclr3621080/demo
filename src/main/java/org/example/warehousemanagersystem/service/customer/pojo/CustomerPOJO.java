package org.example.warehousemanagersystem.service.customer.pojo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Data
public class CustomerPOJO extends BaseFlagPOJO {
    /**
     * 创建时间
     */
    private String CreateTime;
    /**
     * 客户账号
     */
    private  String account;
    /**
     * 头像
     */
    private String customerProfile;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 简介
     */
    private String remark;
    /**
     * 是否是vip
     */
    private Integer isVip;
    private BigDecimal vipDiscount;
    private Integer vipDate;
    private Integer status;
    private Integer buyNumber;
    private String nickName;
    private String phone;

}
