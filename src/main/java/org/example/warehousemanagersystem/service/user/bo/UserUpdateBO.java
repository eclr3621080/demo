package org.example.warehousemanagersystem.service.user.bo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */

@Data
public class UserUpdateBO {
    /**
     * ids
     */
    private Set<Integer> ids;
    /**
     *id
     */
    private Integer id;
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
     *  年龄
     */
    private Integer age;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     *手机
     */
    private Long mobile;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     *
     */
    private Integer roleId;
    private String img;
    private Integer status;

}
