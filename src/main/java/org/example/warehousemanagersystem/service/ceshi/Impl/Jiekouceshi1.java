package org.example.warehousemanagersystem.service.ceshi.Impl;

import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.ceshi.Jiekouceshi;

import org.springframework.stereotype.Service;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-28
 * @Description:
 * @Version: 1.0
 */

@Service
public class Jiekouceshi1 implements Jiekouceshi {
    @Override
    public RetStatus<String> write(Integer amount) {
        RetStatus<String> retStatus = new RetStatus<>();
        retStatus.setData("1");
        return retStatus;
    }

    @Override
    public Integer getType() {
        return 1;
    }

}
