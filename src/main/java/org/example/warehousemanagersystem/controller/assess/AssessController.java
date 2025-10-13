package org.example.warehousemanagersystem.controller.assess;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.assess.bo.AssessAddBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessDeleteBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessUpdateBO;
import org.example.warehousemanagersystem.service.assess.mapper.AssessMapper;
import org.example.warehousemanagersystem.service.assess.service.AssessService;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;
import org.example.warehousemanagersystem.service.assess.vo.AssessListVO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeAddBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeDeleteBO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeListVO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsUpdateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("assess")
@Slf4j
public class AssessController {
    @Autowired
    private AssessService assessService;
    @PostMapping("/list")
    @ResponseBody
    public String listAssess(@RequestBody AssessGetBO assessGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            assessGetBO.setPage(assessGetBO.getCurrent());
            assessGetBO.setLimit(assessGetBO.getSize());
            List<AssessGetVO> list = assessService.getList(assessGetBO);
            AssessListVO assessListVO = new AssessListVO();
            assessListVO.setRecords(list);
            Long Total =assessService.getLong(assessGetBO);
            assessListVO.setTotal(Total);
            retStatus.setData(assessListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @GetMapping("{id}")
    @ResponseBody
    public String infoAssess(@PathVariable Integer id){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            AssessGetBO gameGetBO=new AssessGetBO();
            gameGetBO.setId(id);
            AssessGetVO list = assessService.getOne(gameGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/add")
    @ResponseBody
    public String addAssess(@RequestBody AssessAddBO assessAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            assessService.add(assessAddBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }

    @PostMapping("/update")
    @ResponseBody
    public String updateAssess(@RequestBody AssessUpdateBO assessUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            retStatus=assessService.update(assessUpdateBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }
    @PostMapping("/delete")
    @ResponseBody
    public String deleteAssess(@RequestBody AssessDeleteBO assessDeleteBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = assessService.delete(assessDeleteBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }


}
