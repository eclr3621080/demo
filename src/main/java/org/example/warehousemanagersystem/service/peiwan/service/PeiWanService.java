package org.example.warehousemanagersystem.service.peiwan.service;

import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;

import java.util.List;

public interface PeiWanService {
    List<PeiWanGetVO> list(PeiWanGetBO peiWanGetBO);

    Long getLong(PeiWanGetBO peiWanGetBO);
}
