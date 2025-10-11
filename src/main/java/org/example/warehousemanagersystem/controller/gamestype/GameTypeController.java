package org.example.warehousemanagersystem.controller.gamestype;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.vo.CustomerListVO;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.service.GameTypeService;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeListVO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.example.warehousemanagersystem.service.user.bo.UserUpdateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-10
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("gamestype")
@Slf4j
public class GameTypeController {
    @Autowired
    GameTypeService gameTypeService;
    @PostMapping("/list")
    @ResponseBody
    public String listGameType(@RequestBody GameTypeBO gameTypeBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            gameTypeBO.setPage(gameTypeBO.getCurrent());
            gameTypeBO.setLimit(gameTypeBO.getSize());
            List<GameTypeVO> list = gameTypeService.getList(gameTypeBO);
            GameTypeListVO gameTypeListVO = new GameTypeListVO();
            gameTypeListVO.setRecords(list);
            Long customerTotal =gameTypeService.getLong(gameTypeBO);
            gameTypeListVO.setTotal(customerTotal);
            retStatus.setData(gameTypeListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateGameType(@RequestBody GameTypeUpdateBO gameTypeUpdateBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            StpUtil.isLogin();
            retStatus = gameTypeService.update(gameTypeUpdateBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
}
