package org.example.warehousemanagersystem.service.user.bo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Setter
@Getter
public class UserAddBO {

    private String f_add_time;
    private String f_employee_no;
    private String f_secret;
    private String f_user_name;
    private Integer f_sex;
    private String f_user_avatar;
    private Integer f_age;
    private Long f_mobile;
    private String f_remark;
}
