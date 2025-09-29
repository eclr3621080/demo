package org.example.warehousemanagersystem.service.user.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Data
public class UserGetBO extends BaseGetBO {
    private Integer id;
    private String f_employee_no;
    private String f_user_name;
}
