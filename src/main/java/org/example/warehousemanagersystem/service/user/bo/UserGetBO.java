package org.example.warehousemanagersystem.service.user.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Data
public class UserGetBO extends BaseGetBO {
    private Integer id;
    private String employeeNo;
    private String userName;
    private String userRealName;
    private String email;
    private Integer  status;
    private Integer roleId;
    private Long mobile;
    private String createTimeStart;
    private String createTimeEnd;
    private List<Long> createTimeRange;
    private Integer current;
    private Integer size;
}
