package org.example.warehousemanagersystem.study.a04;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.StandardEnvironment;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DigInAutowired {
    public static void main(String[] args) throws Throwable {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("bean2",new Bean2());//串讲过程，依赖注入，初始化
        beanFactory.registerSingleton("bean3",new Bean3());
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        beanFactory.addEmbeddedValueResolver(new StandardEnvironment()::resolvePlaceholders);//${} 的解析器



        //1查找那些属性、方法加了@Autowired ，这称之为InjectionMetadata
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();




        beanPostProcessor.setBeanFactory(beanFactory);
        Bean1 bean1 = new Bean1();
//        System.out.println(bean1);
//        beanPostProcessor.postProcessProperties(null,bean1,"bean1");
//        System.out.println(bean1);
        Method findAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata", String.class, Class.class, PropertyValues.class);
        findAutowiringMetadata.setAccessible(true);
        //收集
        InjectionMetadata metadata = (InjectionMetadata) findAutowiringMetadata.invoke(beanPostProcessor, "bean1", Bean1.class, null);//获取Bean1上加了@Aalue @Autowired 的成员变量，方法参数信息
        System.out.println(metadata);
        metadata.inject(bean1,"bean1",null);
        System.out.println(bean1);

        //如何按类型查找值
        Field bean3 = Bean1.class.getDeclaredField("bean3");
        DependencyDescriptor dependencyDescriptor = new DependencyDescriptor(bean3, false);
        Object o = beanFactory.doResolveDependency(dependencyDescriptor, null, null, null);
        System.out.println(o);

        Method setBean2 = Bean1.class.getDeclaredMethod("setBean2", Bean2.class);
        DependencyDescriptor dependencyDescriptor1 = new DependencyDescriptor(new MethodParameter(setBean2, 0), false);
        Object o1 = beanFactory.doResolveDependency(dependencyDescriptor1, null, null, null);
        System.out.println(o1);

        Method setHome = Bean1.class.getDeclaredMethod("setHome", String.class);
        DependencyDescriptor dependencyDescriptor2 = new DependencyDescriptor(new MethodParameter(setHome, 0), true);
        Object o2 = beanFactory.doResolveDependency(dependencyDescriptor2, null, null, null);
        System.out.println(o2);
    }
}
