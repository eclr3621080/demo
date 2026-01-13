package org.example.warehousemanagersystem.study.策略模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 将每个算法封装起来，使它们可以互换使用。
 * @Version: 1.0
 */


public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context=new Context(new OperationAdd());
        System.out.println(context.executeStrategy(10, 5));

        context  = new Context(new OperationSubtract());
        System.out.println(context.executeStrategy(10, 5));

        context  = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(10, 5));
    }
}
