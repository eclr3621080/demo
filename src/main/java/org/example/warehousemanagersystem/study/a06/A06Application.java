package org.example.warehousemanagersystem.study.a06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class A06Application {
    private static final Logger log = LoggerFactory.getLogger(A06Application.class.getName());
    //Aware 提供内置的注入手段
    //InitializingBean 接口提供了一种内置的初始化手段
    //内置的注入和初始化不受扩展功能的一下，总会被执行，因此Spring框架内部的类常用它
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyBean.class);
      //  context.registerBean("myConfig1", MyConfig1.class);
        context.registerBean("myConfig2", MyConfig2.class);
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        context.refresh();//顺序1 找到所有的beanFactory 后处理器来执行，2、添加bean 后置处理器 3、执行初始化单例   4
        context.close();
    }
}
