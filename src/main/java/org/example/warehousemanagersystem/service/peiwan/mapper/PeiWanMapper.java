package org.example.warehousemanagersystem.service.peiwan.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanUpdateBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiwanAddBO;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;

import java.util.List;

@Mapper
public interface PeiWanMapper {
    List<PeiWanGetVO> getList(PeiWanGetBO peiWanGetBO);

    PeiWanGetVO getOne(PeiWanGetBO peiWanGetBO);

    Integer update(PeiWanUpdateBO peiWanUpdateBO);

    void add(PeiwanAddBO peiwanAddBO);
}
