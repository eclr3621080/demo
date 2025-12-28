package org.example.warehousemanagersystem.service.peiwan.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.gamestype.pojo.GameTypePOJO;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.example.warehousemanagersystem.service.peiwan.pojo.PeiWanPOJO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class PeiWanGetVO extends PeiWanPOJO {
    private List<GameTypeVO> gameList;
}
