package org.example.warehousemanagersystem.service.peiwan.service.Impl;

import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.mapper.PeiWanMapper;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
