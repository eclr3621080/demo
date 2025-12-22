package org.example.warehousemanagersystem.study.过滤器模式;

import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:为标准（Criteria）创建一个接口。
 * @Version: 1.0
 */


public interface Criteria {
    public List<Person> meetCriteria(List<Person> personList);
}
