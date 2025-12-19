package org.example.warehousemanagersystem.study.a03;

import cn.hutool.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-17
 * @Description:
 * @Version: 1.0
 */



@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor , DestructionAwareBeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    public MyBeanPostProcessor() {
        log.info("MyBeanPostProcessor created-------------sq");
    }
    @Override
    public void postProcessBeforeDestruction(Object o, String beanName) throws BeansException {
        if (beanName.equals("LifeCycleBean")) {
            log.debug("---------销毁之前执行，如@PreDestroy");
            log.info("---------销毁之前执行，如@PreDestroy");
//            System.out.println("---------销毁之前执行，如@PreDestroy");
        }
    }
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass ,String beanName) throws BeansException {
        if (beanName.equals("LifeCycleBean")) {
            log.info("----------实例化之前实现");
        }
        return null;
    }
    @Override
    public boolean postProcessAfterInstantiation(Object bean , String beanName) throws BeansException {
        if (beanName.equals("LifeCycleBean")) {
            log.info("------------实例化之后实现,");

        }
        return true;
    }
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equals("LifeCycleBean")) {
            log.info("------依赖注入阶段执行，如@Autowired,@Value,@Resource");

        }
        return pvs;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException{
        if (beanName.equals("LifeCycleBean")) {
            log.info("--------初始化之前执行，这里返回的对象会代替原版本的bean，@PostConstruct，@ConfigurationProperties");

        }
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException{
        if (beanName.equals("LifeCycleBean")) {
            log.info("--------初始化之后执行，这里返回的对象会代替原版本的bean，如代理增强");

        }
        return bean;
    }
}
