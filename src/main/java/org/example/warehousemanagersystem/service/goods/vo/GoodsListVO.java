package org.example.warehousemanagersystem.service.goods.vo;

import lombok.Data;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Data
public class GoodsListVO {
    private List<GoodsGetVO> records;
    private Long total;
}
