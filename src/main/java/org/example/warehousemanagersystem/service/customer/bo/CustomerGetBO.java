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
public class CustomerGetBO {
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

}
