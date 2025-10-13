package org.example.warehousemanagersystem.service.assess.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.assess.bo.AssessAddBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessDeleteBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessUpdateBO;
import org.example.warehousemanagersystem.service.assess.mapper.AssessMapper;
import org.example.warehousemanagersystem.service.assess.service.AssessService;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Override
    public List<AssessGetVO> getList(AssessGetBO assessGetBO) {
        if (assessGetBO == null|| assessGetBO.getId()<=0) {
            return new ArrayList<>();
        }
        List<AssessGetVO> list= assessMapper.getList(assessGetBO);
        return list;
    }

    @Override
    public Long getLong(AssessGetBO assessGetBO) {
        if (assessGetBO == null|| assessGetBO.getId()<=0) {
            return 0L;
        }
       Long total= assessMapper.getLong(assessGetBO);
        return total;
    }

    @Override
    public AssessGetVO getOne(AssessGetBO gameGetBO) {
        if (gameGetBO == null|| gameGetBO.getId()<=0) {
            return new AssessGetVO();
        }
        AssessGetVO assessGetVO=  assessMapper.getOne(gameGetBO);
        return assessGetVO;
    }

    @Override
    @Transactional
    public void add(AssessAddBO assessAddBO) {
        assessMapper.add(assessAddBO);
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
