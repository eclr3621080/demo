package org.example.warehousemanagersystem.service.gamestype.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.user.vo.UserGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Data
public class GameTypeListVO {
    private List<GameTypeVO> records;
    private Long total;
}
