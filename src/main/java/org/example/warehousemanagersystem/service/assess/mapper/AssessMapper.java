package org.example.warehousemanagersystem.service.assess.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.assess.bo.AssessAddBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessUpdateBO;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-13
 * @Description:
 * @Version: 1.0
 */

@Mapper
public interface AssessMapper {
    Long getLong(AssessGetBO assessGetBO);

    List<AssessGetVO> getList(AssessGetBO assessGetBO);

    AssessGetVO getOne(AssessGetBO gameGetBO);

    void add(AssessAddBO assessAddBO);

    Integer update(AssessUpdateBO assessUpdateBO);
}
