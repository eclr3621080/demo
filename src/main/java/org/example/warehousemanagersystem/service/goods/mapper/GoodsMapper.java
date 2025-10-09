package org.example.warehousemanagersystem.service.goods.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsUpdateBO;
import org.example.warehousemanagersystem.service.goods.pojo.GoodsPOJO;
import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;

import java.util.List;

@Mapper
public interface GoodsMapper {
    void addGoods(GoodsPOJO goodsPOJO);
    List<GoodsGetVO> listGoods(GoodsGetBO goodsGetBO);


    Integer updateGoods(GoodsUpdateBO goodsUpdateBO);

    GoodsGetVO getOne(GoodsGetBO goodsGetBO);
}
