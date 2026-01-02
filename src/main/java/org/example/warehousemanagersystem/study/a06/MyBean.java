package org.example.warehousemanagersystem.study.a06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean implements BeanNameAware , ApplicationContextAware , InitializingBean{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("MyBean.setApplicationContext:"+applicationContext+"当前bean"+this);
    }

    private static final Logger log = LoggerFactory.getLogger(MyBean.class);
    @Override
    public void setBeanName(String s) {

        log.info("MyBean.setBeanName: " + s+"bean自己："+this.getClass().getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("MyBean.afterPropertiesSet:"+this);
    }

    @Autowired
    public void aaa(ApplicationContext applicationContext){
        log.info("MyBean.aaa-----------:"+applicationContext+"<UNK>bean"+this);
    }

    @PostConstruct
    public void init(){
        log.info("MyBean.init*************8:"+this);
    }
}
