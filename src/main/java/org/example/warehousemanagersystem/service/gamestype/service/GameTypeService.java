package org.example.warehousemanagersystem.service.gamestype.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeAddBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeDeleteBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;

import java.util.List;

public interface GameTypeService {
    List<GameTypeVO> getList(GameTypeBO gameTypeBO);

    GameTypeVO getOne(GameTypeBO gameTypeBO);

    Long getLong(GameTypeBO gameTypeBO);

    RetStatus<Object> update(GameTypeUpdateBO gameTypeUpdateBO);

    void add(GameTypeAddBO gameTypeAddBO);

    RetStatus<Object> delete(GameTypeDeleteBO gameTypeDeleteBO);
}
