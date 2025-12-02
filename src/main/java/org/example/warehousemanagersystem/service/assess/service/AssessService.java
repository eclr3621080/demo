package org.example.warehousemanagersystem.service.assess.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.assess.bo.AssessAddBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessDeleteBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.bo.AssessUpdateBO;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;

import java.util.List;

public interface AssessService {
    List<AssessGetVO> getList(AssessGetBO assessGetBO);

    Long getLong(AssessGetBO assessGetBO);

    AssessGetVO getOne(AssessGetBO gameGetBO);

    void add(AssessAddBO assessAddBO);

    RetStatus<Object> update(AssessUpdateBO assessUpdateBO);

    RetStatus<Object> delete(AssessDeleteBO assessDeleteBO);
}
