package org.example.warehousemanagersystem.study.a03;

import org.springframework.context.annotation.Bean;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */


public class TestMethodTemplete {
    public static void main(String[] args) {
        MyBeanFactory myBeanFactory = new MyBeanFactory();
        myBeanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public void inject(Object o) {

                System.out.println("解析,@Autowired");
            }
        });
        myBeanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public void inject(Object o) {

                System.out.println("解析,@Resource");
            }
        });
        myBeanFactory.getBean();

    }
    static class MyBeanFactory{
        public Object getBean(){
            Object bean = new Object();
            System.out.println("构造"+bean);
            System.out.println("依赖注入"+bean);
            System.out.println("初始化"+bean);
            for (BeanPostProcessor beanPostProcessor:getBeanPostProcessors){
                beanPostProcessor.inject(bean);
            }
            return bean;
        }
        private List<BeanPostProcessor> getBeanPostProcessors =new ArrayList<BeanPostProcessor>();
        public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
            getBeanPostProcessors.add(beanPostProcessor);
        }
    }
    static interface BeanPostProcessor{
        public void inject(Object o);//对依赖注入阶段扩展
    }
}
