package org.example.warehousemanagersystem.service.peiwan.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanUpdateBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiwanAddBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiwanDeleteBO;
import org.example.warehousemanagersystem.service.peiwan.mapper.PeiWanMapper;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Service
public class PeiWanServiceImpl implements PeiWanService {
    @Autowired
    PeiWanMapper  peiWanMapper;
    @Override
    public List<PeiWanGetVO> list(PeiWanGetBO peiWanGetBO) {
        try{
            List<PeiWanGetVO> list=   peiWanMapper.getList(peiWanGetBO);
            return Collections.emptyList();
        }catch (Exception e){
            e.printStackTrace();

        }
        return new ArrayList<>();
    }

    @Override
    public Long getLong(PeiWanGetBO peiWanGetBO) {
        return 0L;
    }

    @Override
    public PeiWanGetVO getOne(PeiWanGetBO peiWanGetBO) {
        if (peiWanGetBO.getId()<=0){
            return new PeiWanGetVO();
        }
        PeiWanGetVO peiWanGetVO=  peiWanMapper.getOne(peiWanGetBO);
        return peiWanGetVO;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(PeiWanUpdateBO peiWanUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (peiWanUpdateBO.getId()<=0){
            retStatus.set("-1","数据有误");
            return retStatus;
        }
       Integer i= peiWanMapper.update(peiWanUpdateBO);
        if (i!=1){
            retStatus.set("-1","修改失败");
            return retStatus;
        }
        return retStatus;
    }

    @Override
    @Transactional
    public RetStatus<Object> delete(PeiwanDeleteBO peiwanDeleteBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        if (peiwanDeleteBO.getId()<=0){
            retStatus.set("-1","数据有误");
            return retStatus;
        }
        PeiWanUpdateBO  peiWanUpdateBO=new PeiWanUpdateBO();
        peiWanUpdateBO.setId(peiwanDeleteBO.getId());
        peiWanUpdateBO.setIsDelete(1);
        Integer i= peiWanMapper.update(peiWanUpdateBO);
        if (i!=1){
            retStatus.set("-1","删除失败");
            return retStatus;
        }
        return retStatus;
    }

    @Override
    @Transactional
    public void add(PeiwanAddBO peiwanAddBO) {
        peiWanMapper.add(peiwanAddBO);
    }

}
