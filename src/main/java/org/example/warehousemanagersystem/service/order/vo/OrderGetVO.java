package org.example.warehousemanagersystem.service.order.vo;

import lombok.Data;
import org.example.warehousemanagersystem.common.BaseFlagPOJO;
import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;
import org.example.warehousemanagersystem.service.order.pojo.OrderPOJO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Data
public class OrderGetVO extends OrderPOJO {
    private List<GoodsGetVO> goods;
}
