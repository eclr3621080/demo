package org.example.warehousemanagersystem.functionIImterface;

import java.util.function.Consumer;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class Demo09Lambda {
    public static  void consumerStr(String str, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(str);
//        con2.accept(str);
        con1.andThen(con2).accept(str);//con1连接con2，先执行con1消费数据，再执行con2消费数据
    }

    public static void main(String[] args) {
        consumerStr("Test",s-> System.out.println(s.toLowerCase()),s-> System.out.println(s.toUpperCase()));
    }
}
