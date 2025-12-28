package org.example.warehousemanagersystem.service.ceshi.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.service.ceshi.Jiekouceshi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-28
 * @Description:
 * @Version: 1.0
 */

@Slf4j
@Component
public class WriteFactory {
    @Autowired
    List<Jiekouceshi> writeExecutors;
    //查找书写类型
    public Jiekouceshi  getWrite(Integer amount) {
        return writeExecutors.stream().filter(e -> e.getType().equals(amount)).findFirst().orElse(null);
    }
}
