package org.example.warehousemanagersystem.service.order.enums;

public enum OrderStatusEnums {
     weizhifu(0,"未支付")
    ,yizhifu(1,"已支付")
    ,yiquxiao(2,"已取消")
    ,peiwanzhong(4,"陪玩中")
    ,yiwancheng(3,"已完成")
    ,yipingjia(6,"已评价")
    ;

    public static String getEnum(int code){
        for(OrderStatusEnums o: OrderStatusEnums.values()){
            if(o.getCode() == code ){
                return o.getName();
            }
        }
        return "";
    }

    public static OrderStatusEnums getEnums(int code){
        for(OrderStatusEnums o: OrderStatusEnums.values()){
            if(o.getCode() == code ){
                return o;
            }
        }
        return null;
    }

    OrderStatusEnums(int code, String name){
        this.code = code;
        this.name = name;
    }
    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
