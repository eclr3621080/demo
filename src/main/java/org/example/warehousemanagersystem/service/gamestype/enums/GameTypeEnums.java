package org.example.warehousemanagersystem.service.gamestype.enums;

import org.example.warehousemanagersystem.service.goods.enums.GoodsTypeEnums;

public enum GameTypeEnums {
    shejileixing(1, "射击类型"),
    moba(2, "moba"),
    kapai(3, "卡牌"),
    yangcheng(4, "养成"),
    juesebanyan(5,"角色扮演"),
    shengcun(6,"生存"),
    celue(7,"策略"),
    xiuxian(7,"休闲"),
    tiyu(7,"体育");

    public static String getEnum(int code) {
        for (GameTypeEnums o : GameTypeEnums.values()) {
            if (o.getCode() == code) {
                return o.getName();
            }
        }
        return "";
    }

    public static GameTypeEnums getEnums(int code) {
        for (GameTypeEnums o : GameTypeEnums.values()) {
            if (o.getCode() == code) {
                return o;
            }
        }
        return null;
    }

    GameTypeEnums(int code, String name) {
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
