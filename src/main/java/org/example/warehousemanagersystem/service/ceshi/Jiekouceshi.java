package org.example.warehousemanagersystem.service.ceshi;

import org.example.warehousemanagersystem.common.RetStatus;

public interface Jiekouceshi {
     RetStatus<String> write(Integer amount);
    Integer getType();

}
