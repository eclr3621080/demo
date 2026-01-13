package org.example.warehousemanagersystem.study.命令模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 将请求封装为一个对象，允许用户使用不同的请求对客户端进行参数化。
 * 继承了一个
 * @Version: 1.0
 */


public class CommandPatternDemo {
    public static void main(String[] args) {
        //创建实体类对象
        Stock abcStock  = new Stock();
        //生成好了对象，分配对象
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);
        //收集数据
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        //依次释放数据
        broker.placeOrders();
    }
}
