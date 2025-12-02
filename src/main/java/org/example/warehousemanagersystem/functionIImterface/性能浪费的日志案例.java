package org.example.warehousemanagersystem.functionIImterface;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */


public class 性能浪费的日志案例 {
    public static void showLog(int level,String log){
        if (level==1){
            System.out.println(log);
        }
    }
    public static void main(String[] args) {
        String s1="hello";
        String s2="world";
        String s3="hello world";
        showLog(1,s1+s2+s3);
    }
}
