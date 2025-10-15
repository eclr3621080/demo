package org.example.warehousemanagersystem.service.peiwan.pojo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class PeiWanPOJO extends BaseFlagPOJO {
    private String nickName;
    private String realName;;
    private String sex;
    private String birthday;
    private String address;
    private Integer isSign;
    private BigDecimal star;
    private String idCard;
    private String games;
    /**
     * 是否违规
     */
    private Integer isViolation;
    private String createTime;
    private String updateTime;
    private String avatar;
    private String remark;
    private Integer isliving;
    private  Integer isDelete;
    private  Integer violationDay;
    private String  rank;
    private Integer payType;
    private BigDecimal price;
    private Integer peiwanNumber;
}
