package org.example.warehousemanagersystem.controller.goods;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.goods.bo.GoodsAddBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsDeleteBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsUpdateBO;
import org.example.warehousemanagersystem.service.goods.service.GoodsService;
import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;
import org.example.warehousemanagersystem.service.user.bo.UserAddBO;
import org.example.warehousemanagersystem.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-29
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @PostMapping("/addgoods")
    @ResponseBody
    public String addgoods(@RequestBody GoodsAddBO goodsAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            goodsService.add(goodsAddBO);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/listgoods")
    @ResponseBody
    public String listgoods(@RequestBody GoodsGetBO goodsGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            List<GoodsGetVO> list = goodsService.list(goodsGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/updategoods")
    @ResponseBody
    public String updategoods(@RequestBody GoodsUpdateBO goodsUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            retStatus=goodsService.update(goodsUpdateBO);

        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/deletegoods")
    @ResponseBody
    public String deletegoods(@RequestBody GoodsDeleteBO goodsDeleteBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            retStatus=goodsService.delete(goodsDeleteBO);

        }catch (Exception e){
            retStatus.set(-1, e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
}
