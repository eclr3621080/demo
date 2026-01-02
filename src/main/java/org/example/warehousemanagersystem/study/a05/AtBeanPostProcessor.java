package org.example.warehousemanagersystem.study.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

public class AtBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();

        MetadataReader metadataReader = null;
        try {
            metadataReader = cachingMetadataReaderFactory.getMetadataReader(new ClassPathResource("org\\\\example\\\\warehousemanagersystem\\\\study\\\\a05\\\\Config.class"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Set<MethodMetadata> annotatedMethods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(Bean.class.getName());
        for (MethodMetadata annotatedMethod : annotatedMethods) {

            System.out.println(annotatedMethod);

            String initMethod = annotatedMethod.getAllAnnotationAttributes(Bean.class.getName()).get("initMethod").toString();
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
            beanDefinitionBuilder.setFactoryMethodOnBean(annotatedMethod.getMethodName(),"config");//获取方法名
            beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
            if (!initMethod.isEmpty()&&!initMethod.equals("[]")){
                String replace = initMethod.replace("[", "").replace("]", "");
                beanDefinitionBuilder.setInitMethodName(replace);
            }


            if (configurableListableBeanFactory instanceof ConfigurableListableBeanFactory) {
                DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
                AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
                beanFactory.registerBeanDefinition(annotatedMethod.getMethodName(),beanDefinition);
            }

        }

    }
}
