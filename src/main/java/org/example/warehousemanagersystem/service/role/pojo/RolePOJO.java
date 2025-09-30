package org.example.warehousemanagersystem.service.role.pojo;

import lombok.Data;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Data
public class RolePOJO {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色标识
     */
    private String rolekey;
    /**
     * 角色名称
     */
    private String rolename;
    /**
     * 菜单id
     */
    private Integer menuid;
    /**
     * 创建时间
     */
    private String addtime;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态:0-正常,1-禁用
     */
    private Integer status;
    /**
     * 逻辑删除:0-未删除,1-已删除
     */
    private Integer isDelete;
    /**
     * 修改时间
     */
    private String updatetime;

}
