package org.example.warehousemanagersystem.service.peiwan.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;
import org.example.warehousemanagersystem.service.peiwan.pojo.PeiWanPOJO;

import java.math.BigDecimal;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class PeiWanGetBO extends BaseGetBO {
    private Integer id;
    private Integer current;
    private Integer size;
    private String nickName;
    private String realName;;
    private String sex;
    private String birthday;
    private String address;
    private String isSign;
    private BigDecimal star;
    private String idCard;
    private Integer isViolation;
    private String createTime;
    private String updateTime;
    private String avatar;
    private String remark;
    private Integer isliving;
}
