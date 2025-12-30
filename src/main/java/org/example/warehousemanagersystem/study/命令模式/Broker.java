package org.example.warehousemanagersystem.study.命令模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class Broker {
    //把接口当作泛型
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }
    public void placeOrders(){
        for (Order order : orderList){
            order.execute();
        }
        orderList.clear();
    }
}
