package org.example.warehousemanagersystem.functionIImterface;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class Demo03Lambda {
    public static void showLog(int level,MessageBuilder mBuilder){
        if (level==1){
            System.out.println(mBuilder.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "hello";
        String msg2 = "world";
        String msg3 = "java";
        /**
         * 使用lambda表达式作为参数传递，仅仅是把参数传递给showLog方法中,
         * 只有满足条件，日志的等级是1，才会调用接口MessageBuilder中的方法，
         * 才会进行字符串的拼接
         *
         *
         * 也就是说只有进入到if语句中，才会去拼接String
         */
        showLog(1,()->msg1+msg2+msg3);
    }
}
