package org.example.warehousemanagersystem.service.peiwan.service.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.service.GameTypeService;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.example.warehousemanagersystem.service.peiwan.bo.*;
import org.example.warehousemanagersystem.service.peiwan.mapper.PeiWanMapper;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    GameTypeService gameTypeService;

    @Override
    public List<PeiWanGetVO> list(PeiWanGetBO peiWanGetBO) {
        try{
            GameTypeBO gameTypeBO=new GameTypeBO();
            List<GameTypeVO> GameList = gameTypeService.getList(gameTypeBO);
            peiWanGetBO.setIsDelete(0);
            List<PeiWanGetVO> list=   peiWanMapper.getList(peiWanGetBO);
            for (PeiWanGetVO peiWanGetVO:list){
                String games = peiWanGetVO.getGames();
                List<GameTypeVO> gamesList=new ArrayList<>();
                if (!StringUtils.isEmpty(games)){
                    String[] split = games.split("，");
                    List<String> splitlist = Arrays.asList(split);
                    for (String s : splitlist) {
                        for (GameTypeVO gameTypeVO:GameList){
                            if (s.equals(String.valueOf(gameTypeVO.getId()))) {
                                gamesList.add(gameTypeVO);
                            }
                        }
                    }

                }
                peiWanGetVO.setGameList(gamesList);
            }
            return list;
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
        GameTypeBO gameTypeBO=new GameTypeBO();
        List<GameTypeVO> GameList = gameTypeService.getList(gameTypeBO);
        String games = peiWanGetVO.getGames();
        List<GameTypeVO> gamesList=new ArrayList<>();
        if (!StringUtils.isEmpty(games)){
            String[] split = games.split("，");
            List<String> splitlist = Arrays.asList(split);
            for (String s : splitlist) {
                for (GameTypeVO gameTypeVO:GameList){
                    if (s.equals(String.valueOf(gameTypeVO.getId()))) {
                        gamesList.add(gameTypeVO);
                    }
                }
            }

        }
        peiWanGetVO.setGameList(gamesList);
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

    @Override
    public List<PeiWanGetVO> getPeiWanByGameType(PeiWanGetByGameTypeBO peiWanGetByGameTypeBO) {
        GameTypeBO gameTypeBO=new GameTypeBO();
        gameTypeBO.setGameType(peiWanGetByGameTypeBO.getGameTypeId());
        List<GameTypeVO> list = gameTypeService.getList(gameTypeBO);
        PeiWanGetBO peiWanGetBO=new PeiWanGetBO();
        List<PeiWanGetVO>  peiWanGetVOList=new ArrayList<>();
        List<PeiWanGetVO> list1 = peiWanMapper.getList(peiWanGetBO);
        for (PeiWanGetVO peiWanGetVO:list1){
            for (GameTypeVO gameTypeVO:list){
                if (peiWanGetVO.getGames().contains(String.valueOf(gameTypeVO.getId()))){
                    peiWanGetVOList.add(peiWanGetVO);
                }
            }
        }
        return peiWanGetVOList;
    }

}
