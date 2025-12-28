package org.example.warehousemanagersystem.common;

import lombok.Data;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Data
public class BaseGetBO {
    private Integer page=1;

    private Integer limit=10;
    public Integer getPageSize() {
        if(this.page != null && this.page > 0){
            return this.page*this.limit - this.limit;
        }
        return -1;
    }
}
