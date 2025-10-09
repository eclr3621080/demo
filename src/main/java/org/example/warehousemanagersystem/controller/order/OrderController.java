package org.example.warehousemanagersystem.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String listUser(@RequestBody OrderGetBO orderGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            List<OrderGetVO> list = orderService.list(orderGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
}
