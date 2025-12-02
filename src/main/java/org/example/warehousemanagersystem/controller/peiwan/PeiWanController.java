package org.example.warehousemanagersystem.controller.peiwan;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.peiwan.bo.*;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查看陪玩列表
     * @param peiWanGetBO
     * @return
     */
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
    @GetMapping("{id}")
    @ResponseBody
    public String infoPeiWan(@PathVariable Integer id){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            PeiWanGetBO peiWanGetBO=new PeiWanGetBO();
            peiWanGetBO.setId(id);
            PeiWanGetVO list = peiWanService.getOne(peiWanGetBO);

            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/getlistbygametype")
    @ResponseBody
    public String getInfoByGameType(@RequestBody PeiWanGetByGameTypeBO peiWanGetByGameTypeBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{

            List<PeiWanGetVO> list = peiWanService.getPeiWanByGameType(peiWanGetByGameTypeBO);

            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/update")
    @ResponseBody
    public String updatePeiWan(@RequestBody PeiWanUpdateBO peiWanUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            retStatus=peiWanService.update(peiWanUpdateBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/delete")
    @ResponseBody
    public String deletePeiWan(@RequestBody PeiwanDeleteBO peiWanUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            retStatus=peiWanService.delete(peiWanUpdateBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/add")
    @ResponseBody
    public String addPeiWan(@RequestBody PeiwanAddBO peiwanAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            peiWanService.add(peiwanAddBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
}
