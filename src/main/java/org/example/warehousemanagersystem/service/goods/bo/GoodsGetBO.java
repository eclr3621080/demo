package org.example.warehousemanagersystem.service.goods.bo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseGetBO;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */

@Data
public class GoodsGetBO extends BaseGetBO {
    private Integer id;
    private String goodsName;
}
