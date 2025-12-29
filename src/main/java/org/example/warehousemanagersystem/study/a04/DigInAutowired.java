package org.example.warehousemanagersystem.study.a04;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.env.StandardEnvironment;

import javax.swing.*;
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
    }
}
