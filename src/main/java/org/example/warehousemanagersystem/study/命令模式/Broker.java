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
    //把接口当作泛型，类似于数据存储
    private List<Order> orderList = new ArrayList<Order>();
    //往数据存储中添加数据
    public void takeOrder(Order order){
        orderList.add(order);
    }
    //执行数据存储中每一个order
    public void placeOrders(){
        for (Order order : orderList){
            order.execute();
        }
        //执行完之后清空
        orderList.clear();
    }
}
