package org.example.warehousemanagersystem.study.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:创建一个 Meal 类，带有上面定义的 Item 对象。
 * @Version: 1.0
 */


public class Meal {
    private List<Item> items=new ArrayList<>();

    public  void  addItem(Item item){
        items.add(item);
    }

    public  float getCost(){
        float cost=0.0f;
        for (Item item:items){
            cost+=item.price();
        }
        return cost;
    }

    public void  showItems(){
        for (Item item:items){
            System.out.println("item:"+item.name());
            System.out.println(",price:"+item.price());
            System.out.println(",Packing:"+item.packing().pack());
        }
    }
}
