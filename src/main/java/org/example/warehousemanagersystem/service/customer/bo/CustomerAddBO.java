package org.example.warehousemanagersystem.service.customer.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Data
public class CustomerAddBO {
    /**
     * 创建时间
     */
    private Date addtime;
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
    private String secret;
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
}
