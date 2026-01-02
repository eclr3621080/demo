package org.example.warehousemanagersystem.study.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ComponentScan annotation = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
        if (annotation != null) {
            for (String s : annotation.basePackages()) {
                System.out.println(s);
                //org.example.warehousemanagersystem.study.a05.component==>classpath*:org/example/warehousemanagersystem/study/a05/component/**/*.class
                String path="classpath*:"+s.replace(".","/")+ "/**/*.class";
                System.out.println(path);
                //读取元信息
                CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
                AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
                Resource[] resources = null;
                try {
                    resources = new PathMatchingResourcePatternResolver().getResources(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Resource resource : resources) {
                    System.out.println(resource);
                    MetadataReader metadataReader = null;
                    try {
                        metadataReader = cachingMetadataReaderFactory.getMetadataReader(resource);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(metadataReader.getClassMetadata().getClassName());//得到二进制类元信息,类名称
                    boolean b = metadataReader.getAnnotationMetadata().hasAnnotation(Component.class.getName());
                    System.out.println(metadataReader.getAnnotationMetadata().hasMetaAnnotation(Component.class.getName()));//检查间接加了component
                    if (metadataReader.getAnnotationMetadata().hasAnnotation(Component.class.getName())||metadataReader.getAnnotationMetadata().hasMetaAnnotation(Component.class.getName())){
                        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(metadataReader.getClassMetadata().getClassName()).getBeanDefinition();
                        if (configurableListableBeanFactory instanceof DefaultListableBeanFactory ) {
                            DefaultListableBeanFactory defaultListableBeanFactory= new DefaultListableBeanFactory();
                            String s1 = generator.generateBeanName(beanDefinition, defaultListableBeanFactory);
                            defaultListableBeanFactory.registerBeanDefinition(s1, beanDefinition);
                        }


                    }
                }
            }
        }
    }
}
