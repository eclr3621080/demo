package org.example.warehousemanagersystem.service.gamestype.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.mapper.GameTypeMapper;
import org.example.warehousemanagersystem.service.gamestype.service.GameTypeService;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Service
public class GameTypeServiceImpl implements GameTypeService {
    @Autowired
    GameTypeMapper gameTypeMapper;
    @Override
    public List<GameTypeVO> getList(GameTypeBO gameTypeBO) {
        List<GameTypeVO> list=  gameTypeMapper.getList(gameTypeBO);
        return list;
    }

    @Override
    public Long getLong(GameTypeBO gameTypeBO) {
        Long total= gameTypeMapper.getLong(gameTypeBO);
        return total;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(GameTypeUpdateBO gameTypeUpdateBO) {
        RetStatus<Object>  retStatus = new RetStatus<>();
        if (gameTypeUpdateBO.getId()==0){
            retStatus.set("-1","数据错误");
            return retStatus;
        }
        Integer i = gameTypeMapper.update(gameTypeUpdateBO);
         if (i!=1){
             retStatus.set("-1","数据有误，更新失败");
         }
        return retStatus;
    }
}
