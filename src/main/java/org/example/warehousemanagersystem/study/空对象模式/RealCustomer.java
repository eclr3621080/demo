package org.example.warehousemanagersystem.study.空对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:创建扩展了上述类的实体类。
 * @Version: 1.0
 */


public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }
    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
