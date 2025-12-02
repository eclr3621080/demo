package org.example.warehousemanagersystem.functionIImterface;

/**
 * 函数式接口在java中是指 :有且仅有一个抽象方法的接口，当然接口中也可以包含其他的方法（默认，静态，私有）
 * 接口中的抽象方法的public abstract可以省略。
 * @FunctionalInterface可以检测接口是否为函数式接口（是编译成功；否编译失败-接口中没有抽象方法或抽象方法个数多于一个）。
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    public abstract String method();


}
