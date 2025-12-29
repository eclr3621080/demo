package org.example.warehousemanagersystem.study.命令模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class SellStock implements Order{
    private Stock abcStock;
    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }
    @Override
    public void execute() {
        abcStock.sell();
    }
}
