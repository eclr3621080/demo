package org.example.warehousemanagersystem.service.peiwan.service;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanUpdateBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiwanAddBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiwanDeleteBO;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;

import java.util.List;

public interface PeiWanService {
    List<PeiWanGetVO> list(PeiWanGetBO peiWanGetBO);

    Long getLong(PeiWanGetBO peiWanGetBO);

    PeiWanGetVO getOne(PeiWanGetBO peiWanGetBO);

    RetStatus<Object> update(PeiWanUpdateBO peiWanUpdateBO);

    RetStatus<Object> delete(PeiwanDeleteBO peiWanUpdateBO);

    void add(PeiwanAddBO peiwanAddBO);
}
