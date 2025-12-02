package org.example.warehousemanagersystem.service.gamestype.service.Impl;

import com.alibaba.fastjson.JSONObject;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeAddBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeDeleteBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.mapper.GameTypeMapper;
import org.example.warehousemanagersystem.service.gamestype.service.GameTypeService;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public GameTypeVO getOne(GameTypeBO gameTypeBO) {
        GameTypeVO gameTypeVO=  gameTypeMapper.getOne(gameTypeBO);
        return gameTypeVO;
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
        String gameIcon = gameTypeUpdateBO.getGameIcon();
        RetStatus retStatus1 = JSONObject.parseObject(gameIcon, RetStatus.class);
        gameTypeUpdateBO.setGameIcon((String) retStatus1.getData());
        Integer i = gameTypeMapper.update(gameTypeUpdateBO);
         if (i!=1){
             retStatus.set("-1","数据有误，更新失败");
         }
        return retStatus;
    }

    @Override
    @Transactional
    public void add(GameTypeAddBO gameTypeAddBO) {
        gameTypeMapper.add(gameTypeAddBO);
    }

    @Override
    @Transactional
    public RetStatus<Object>  delete(GameTypeDeleteBO gameTypeDeleteBO) {
        RetStatus<Object>  retStatus = new RetStatus<>();
        if (gameTypeDeleteBO.getId()<=0){
            retStatus.set("-1","输入id错误");
            return retStatus;
        }
        GameTypeBO gameTypeBO=new GameTypeBO();
        gameTypeBO.setId(gameTypeDeleteBO.getId());
        GameTypeVO one = gameTypeMapper.getOne(gameTypeBO);
        if (one==null){
            retStatus.set("-1","不存在该游戏类型");
            return retStatus;
        }
        if (one.getIsDelete()==1){
            retStatus.set("-1","该游戏类型已经被删除");
            return retStatus;
        }
        GameTypeUpdateBO gameTypeUpdateBO=new GameTypeUpdateBO();
        gameTypeUpdateBO.setId(gameTypeDeleteBO.getId());
        gameTypeUpdateBO.setIsDelete(1);
        Integer update = gameTypeMapper.update(gameTypeUpdateBO);
        if (update!=1){
            retStatus.set("-1","删除失败");
            return retStatus;
        }
        return retStatus;
    }
}
