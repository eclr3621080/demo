package org.example.warehousemanagersystem.study.a06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.spi.InitialContextFactory;
@Configuration
public class MyConfig2 implements InitializingBean, ApplicationContextAware {
    private static  final Logger logger = LoggerFactory.getLogger(MyConfig2.class);
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("Initializing MyConfig2");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
logger.debug("ApplicationContext MyConfig2");
    }
    @Bean
    public BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return beanFactory -> {
            logger.debug("BeanFactoryPostProcessor2%%%%%%%%%%%%%%%%%%%555555555");
        };
    }
}
