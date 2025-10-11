package org.example.warehousemanagersystem.service.gamestype.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;

import java.util.List;

public interface GameTypeService {
    List<GameTypeVO> getList(GameTypeBO gameTypeBO);

    Long getLong(GameTypeBO gameTypeBO);

    RetStatus<Object> update(GameTypeUpdateBO gameTypeUpdateBO);
}
