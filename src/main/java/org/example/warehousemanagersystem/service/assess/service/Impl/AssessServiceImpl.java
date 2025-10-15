package org.example.warehousemanagersystem.service.assess.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.assess.bo.AssessAddBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessDeleteBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessUpdateBO;
import org.example.warehousemanagersystem.service.assess.mapper.AssessMapper;
import org.example.warehousemanagersystem.service.assess.service.AssessService;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.service.CustomerService;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanUpdateBO;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */
@Service
public class AssessServiceImpl implements AssessService {
    @Autowired
    AssessMapper assessMapper;
    @Autowired
    PeiWanService  peiWanService;
    @Autowired
    CustomerService customerService;

    @Override
    public List<AssessGetVO> getList(AssessGetBO assessGetBO) {
        if (assessGetBO == null) {
            return new ArrayList<>();
        }
        return assessMapper.getList(assessGetBO);
    }

    @Override
    public Long getLong(AssessGetBO assessGetBO) {
        if (assessGetBO == null|| assessGetBO.getId()<=0) {
            return 0L;
        }
        return assessMapper.getLong(assessGetBO);
    }

    @Override
    public AssessGetVO getOne(AssessGetBO gameGetBO) {
        if (gameGetBO == null|| gameGetBO.getId()<=0) {
            return new AssessGetVO();
        }
        return assessMapper.getOne(gameGetBO);
    }

    @Override
    @Transactional
    public void add(AssessAddBO assessAddBO) {
        Object loginId = StpUtil.getLoginId();
        CustomerGetBO customerGetBO=new CustomerGetBO();
        customerGetBO.setAccount(String.valueOf(loginId));
        CustomerVO one = customerService.getOne(customerGetBO);
        //添加评论
        assessAddBO.setCustomerId(one.getId());
        assessMapper.add(assessAddBO);
        //更具评论，收集所有的该陪玩的评价星级，给一个平均值
        //先收集
        AssessGetBO assessGetBO=new AssessGetBO();
        assessGetBO.setPeiwanId(assessAddBO.getPeiwanId());
        List<AssessGetVO> list = assessMapper.getList(assessGetBO);
        BigDecimal star=new BigDecimal(0);
        for (AssessGetVO assessGetVO : list) {
            star.add(assessGetVO.getStar());
        }
        //修改这个陪玩的评价
        BigDecimal average=star.divide(new BigDecimal(list.size()));
        PeiWanUpdateBO peiWanUpdateBO=new PeiWanUpdateBO();
        peiWanUpdateBO.setId(assessAddBO.getPeiwanId());
        peiWanUpdateBO.setStar(average);
        peiWanService.update(peiWanUpdateBO);

    }

    @Override
    @Transactional
    public RetStatus<Object> update(AssessUpdateBO assessUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (assessUpdateBO == null|| assessUpdateBO.getId()<=0) {
            retStatus.set("-1","数据有误");
            return retStatus;
        }
       Integer i= assessMapper.update(assessUpdateBO);
        if (i!=1){
            retStatus.set("-1","更新有误");
            return retStatus;
        }
        AssessGetBO assessGetBO=new AssessGetBO();
        assessGetBO.setPeiwanId(assessUpdateBO.getPeiwanId());
        List<AssessGetVO> list = assessMapper.getList(assessGetBO);
        BigDecimal star=new BigDecimal(0);
        for (AssessGetVO assessGetVO : list) {
            star.add(assessGetVO.getStar());
        }
        //修改这个陪玩的评价
        BigDecimal average=star.divide(new BigDecimal(list.size()));
        PeiWanUpdateBO peiWanUpdateBO=new PeiWanUpdateBO();
        peiWanUpdateBO.setId(assessUpdateBO.getPeiwanId());
        peiWanUpdateBO.setStar(average);
        peiWanService.update(peiWanUpdateBO);


        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> delete(AssessDeleteBO assessDeleteBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (assessDeleteBO == null|| assessDeleteBO.getId()<=0) {
            retStatus.set("-1","数据有误");
            return retStatus;
        }
        AssessUpdateBO assessUpdateBO = new AssessUpdateBO();
        assessUpdateBO.setId(assessDeleteBO.getId());
        assessUpdateBO.setIsDelete(1);
        Integer i= assessMapper.update(assessUpdateBO);
        if (i!=1){
            retStatus.set("-1","更新有误");
            return retStatus;
        }
        return retStatus;
    }

}
