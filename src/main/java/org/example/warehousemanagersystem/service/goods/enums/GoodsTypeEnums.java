package org.example.warehousemanagersystem.service.goods.enums;

import org.example.warehousemanagersystem.service.order.enums.OrderStatusEnums;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-10
 * @Description:
 * @Version: 1.0
 */


public enum GoodsTypeEnums {

     csgo(1, "cs2"),
    yxlm(2, "英雄联盟"),
    lscs(3, "炉石传说"),
    yiwancheng(4, "三角洲"),
    vllt(5,"瓦洛兰特"),
    jdqs(6,"绝地求生"),
    diwurenge(7,"第五人格");

    public static String getEnum(int code) {
        for (GoodsTypeEnums o : GoodsTypeEnums.values()) {
            if (o.getCode() == code) {
                return o.getName();
            }
        }
        return "";
    }

    public static GoodsTypeEnums getEnums(int code) {
        for (GoodsTypeEnums o : GoodsTypeEnums.values()) {
            if (o.getCode() == code) {
                return o;
            }
        }
        return null;
    }

    GoodsTypeEnums(int code, String name) {
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
