package org.example.warehousemanagersystem.controller.role;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.role.bo.RoleGetBO;
import org.example.warehousemanagersystem.service.role.service.RoleService;
import org.example.warehousemanagersystem.service.role.vo.RoleVO;
import org.example.warehousemanagersystem.service.user.bo.UserGetBO;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
@Slf4j
public class roleController {
    @Autowired
    RoleService roleService;
    @PostMapping("/list")
    @ResponseBody
    public String listRole(@RequestBody RoleGetBO roleGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            List<RoleVO> list = roleService.getRoleList(roleGetBO);
            retStatus.setData(list);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
}
