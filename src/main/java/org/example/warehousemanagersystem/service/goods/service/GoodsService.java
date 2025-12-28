package org.example.warehousemanagersystem.service.goods.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.goods.bo.GoodsAddBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsDeleteBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsUpdateBO;
import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.user.bo.UserAddBO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */


public interface GoodsService {
    void  add(GoodsAddBO  goodsAddBO);
    List<GoodsGetVO> list(GoodsGetBO goodsGetBO);

    RetStatus<Object> update(GoodsUpdateBO goodsUpdateBO);

    RetStatus<Object> delete(GoodsDeleteBO goodsDeleteBO);

    GoodsGetVO getone(GoodsGetBO goodsGetBO);
}
