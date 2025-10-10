package org.example.warehousemanagersystem.controller.order;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.vo.GoodsGetVO;
import org.example.warehousemanagersystem.service.order.bo.OrderAddBO;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.bo.OrderUpdateBO;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.order.vo.OrderListVO;
import org.example.warehousemanagersystem.service.user.bo.UserAddBO;
import org.example.warehousemanagersystem.service.user.bo.UserUpdateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-30
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/list")
    @ResponseBody
    public String listOrder(@RequestBody OrderGetBO orderGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            orderGetBO.setPage(orderGetBO.getCurrent());
            orderGetBO.setLimit(orderGetBO.getSize());
            List<OrderGetVO> list = orderService.list(orderGetBO);
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setRecords(list);
           Long ordertotal = orderService.getLong(orderGetBO);
            orderListVO.setTotal(ordertotal);
            retStatus.setData(orderListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }

        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @GetMapping("{id}")
    @ResponseBody
    public String infoOrder(@PathVariable Integer id){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            OrderGetBO orderGetBO=new OrderGetBO();
            orderGetBO.setId(id);
            OrderGetVO list = orderService.getone(orderGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/update")
    @ResponseBody
    public String updateOrder(@RequestBody OrderUpdateBO orderUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = orderService.update(orderUpdateBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/add")
    @ResponseBody
    public String addOrder(@RequestBody OrderAddBO orderAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            orderService.add(orderAddBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
}
