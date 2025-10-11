package org.example.warehousemanagersystem.service.gamestype.pojo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;
import org.example.warehousemanagersystem.service.customer.pojo.CustomerPOJO;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class GameTypePOJO extends BaseFlagPOJO {
    /**
     * 游戏类型
     */
    private Integer gameType;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 游戏图标
     */
    private  String gameIcon;
    /**
     * 游戏销售数量
     */
    private Integer gameNumber;
    /**
     * 游戏状态
     */
    private Integer gameStatus;
    /**
     * 是否被删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
