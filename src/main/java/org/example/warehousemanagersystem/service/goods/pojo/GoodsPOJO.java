package org.example.warehousemanagersystem.service.goods.pojo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */

@Data
public class GoodsPOJO extends BaseFlagPOJO {

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 商品头像/图片
     */
    private String goodsImg;
    /**
     * 商品数量
     */
    private Integer goodsNumber;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrices;
    /**
     * 商品入库时间
     */
    private String goodsInTime;
    /**
     * 商品有效时间（天）
     */
    private Integer goodsAbleTime;
    /**
     * 商品是否有效 (0:无效, 1:有效)
     */
    private Integer goodsIsAble;
    /**
     * 商品库存数量
     */
    private Integer goodsRemainNumber;
    /**
     * 商品进价
     */
    private String goodsRemark;
    /**
     * 商品进价
     */
    private BigDecimal goodsInPrice;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 是否删除 (0:未删除, 1:已删除)
     */
    private Integer isDelete;
}
