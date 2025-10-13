package org.example.warehousemanagersystem.controller.peiwan;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.order.vo.OrderListVO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("peiwan")
@Slf4j
public class PeiWanController {
    @Autowired
    private PeiWanService peiWanService;
    @PostMapping("/list")
    @ResponseBody
    public String listPeiWan(@RequestBody PeiWanGetBO peiWanGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            peiWanGetBO.setPage(peiWanGetBO.getCurrent());
            peiWanGetBO.setLimit(peiWanGetBO.getSize());
            List<PeiWanGetVO> list = peiWanService.list(peiWanGetBO);
            PeiWanListVO peiWanListVO = new PeiWanListVO();
            peiWanListVO.setRecords(list);
            Long ordertotal = peiWanService.getLong(peiWanGetBO);
            peiWanListVO.setTotal(ordertotal);
            retStatus.setData(peiWanListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }

        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }

}
