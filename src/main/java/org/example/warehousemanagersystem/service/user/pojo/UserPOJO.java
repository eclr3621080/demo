package org.example.warehousemanagersystem.service.user.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Setter
@Getter
public class UserPOJO  extends BaseFlagPOJO {
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 工号
     */
    private String employeeNo;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机
     */
    private Long mobile;
    /**
     * 是否禁用
     */
    private Integer isDelete;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新时间
     */
    private String updateTime;

    private String token;

    private List<Integer> roles;

   private Integer roleId;
   private Integer status;
   private String email;
   private String userRealName;
}
