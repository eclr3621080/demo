package org.example.warehousemanagersystem.service.gamestype.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;

import java.util.List;

@Mapper
public interface GameTypeMapper {
    Long getLong(GameTypeBO gameTypeBO);

    List<GameTypeVO> getList(GameTypeBO gameTypeBO);

    Integer update(GameTypeUpdateBO gameTypeUpdateBO);
}
