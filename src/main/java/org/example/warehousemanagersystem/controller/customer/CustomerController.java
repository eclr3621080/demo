package org.example.warehousemanagersystem.controller.customer;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.CustomerAddBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerLoginBO;
import org.example.warehousemanagersystem.service.customer.pojo.CustomerPOJO;
import org.example.warehousemanagersystem.service.customer.service.CustomerService;
import org.example.warehousemanagersystem.service.customer.vo.CustomerListVO;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.user.bo.UserLoginBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Controller
@RequestMapping("customer")
@Slf4j
public class CustomerController {
    @Autowired
     CustomerService customerService;
    @PostMapping("/list")
    @ResponseBody
    public String listCustomer(@RequestBody CustomerGetBO customerGetBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            customerGetBO.setPage(customerGetBO.getCurrent());
            customerGetBO.setLimit(customerGetBO.getSize());
            List<CustomerVO> list = customerService.getList(customerGetBO);
            CustomerListVO customerListVO = new CustomerListVO();
            customerListVO.setRecords(list);
            Long customerTotal =customerService.getLong(customerGetBO);
            customerListVO.setTotal(customerTotal);
            retStatus.setData(customerListVO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @GetMapping("/detail")
    @ResponseBody
    public String detailCustomer(){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            CustomerGetBO  customerGetBO=new CustomerGetBO();
            String account = StpUtil.getLoginId().toString();


            customerGetBO.setAccount(account);
           CustomerVO customerVO = customerService.getOne(customerGetBO);
            retStatus.setData(customerVO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }

    @PostMapping("/add")
    @ResponseBody
    public String addCustomer(@RequestBody CustomerAddBO customerAddBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{

            customerService.add(customerAddBO);
        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody CustomerLoginBO customerLoginBO){
        RetStatus<Object> retStatus = new RetStatus<>();
        try{
            retStatus= customerService.login(customerLoginBO);

        }catch (Exception e){
            retStatus.set("-1", e.getMessage());
        }
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }

}
