package org.example.warehousemanagersystem.service.goods.service.Impl;

import com.alibaba.fastjson.JSONObject;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.goods.bo.GoodsAddBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsDeleteBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsUpdateBO;
import org.example.warehousemanagersystem.service.goods.mapper.GoodsMapper;
import org.example.warehousemanagersystem.service.goods.pojo.GoodsPOJO;
import org.example.warehousemanagersystem.service.goods.service.GoodsService;

import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public void add(GoodsAddBO goodsAddBO) {
        GoodsPOJO goodsPOJO = new GoodsPOJO();
        BeanUtils.copyProperties(goodsAddBO,goodsPOJO);
        goodsMapper.addGoods(goodsPOJO);
    }

    @Override
    public List<GoodsGetVO> list(GoodsGetBO goodsGetBO) {
        List<GoodsGetVO> goodsGetVOS = goodsMapper.listGoods(goodsGetBO);
        return goodsGetVOS;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(GoodsUpdateBO goodsUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (goodsUpdateBO.getGoodsImg()!=null){
            RetStatus jsonObject = JSONObject.parseObject(goodsUpdateBO.getGoodsImg(),RetStatus.class);
            goodsUpdateBO.setGoodsImg(jsonObject.getData().toString());
        }
        if (goodsUpdateBO.getId() == null || goodsUpdateBO.getId()<=0) {
            retStatus.set("-1","数据异常");
            return retStatus;
        }
        Integer i = goodsMapper.updateGoods(goodsUpdateBO);
        if (i != 1) {
            retStatus.set("-1", "更新失败");
        }
        return retStatus;
    }

    @Override
    public RetStatus<Object> delete(GoodsDeleteBO goodsDeleteBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (goodsDeleteBO.getId() == null || goodsDeleteBO.getId()<=0) {
            retStatus.set("-1","数据异常");
            return retStatus;
        }
        GoodsUpdateBO goodsUpdateBO=new GoodsUpdateBO();
        goodsUpdateBO.setId(goodsDeleteBO.getId());
        goodsUpdateBO.setIsDelete(1);
        Integer i = goodsMapper.updateGoods(goodsUpdateBO);
        if (i != 1) {
            retStatus.set("-1", "更新失败");
        }
        return retStatus;
    }

    @Override
    public GoodsGetVO getone(GoodsGetBO goodsGetBO) {
        GoodsGetVO goodsGetVOS = goodsMapper.getOne(goodsGetBO);
        return goodsGetVOS;
    }
}
