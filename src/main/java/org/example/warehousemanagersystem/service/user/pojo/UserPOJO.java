package org.example.warehousemanagersystem.service.user.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Setter
@Getter
public class UserPOJO  extends BaseFlagPOJO {
    private String addTime;
    private String employeeNo;
    private String secret;
    private String userName;
    private Integer sex;
    private String userAvatar;
    private Integer age;
    private Long mobile;
    private String remark;

}
