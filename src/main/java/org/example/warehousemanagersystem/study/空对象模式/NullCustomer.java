package org.example.warehousemanagersystem.study.空对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */


public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}
