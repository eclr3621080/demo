package org.example.warehousemanagersystem.study.a05;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;

public class MapperPostProcessor implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resource = null;
        try {
            resource = resolver.getResources("classpath:org/example/warehousemanagersystem/study/a05/mapper/**/*.class");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AnnotationBeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
        for (Resource resource1 : resource) {
            try {
                MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(resource1);
                ClassMetadata classMetadata = metadataReader.getClassMetadata();
                if (classMetadata.isInterface()) {
                    System.out.println(classMetadata.getClassName());
                    AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MapperFactoryBean.class)
                            .addConstructorArgValue(classMetadata.getClassName())
                            .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE)
                            .getBeanDefinition();
                    AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition(classMetadata.getClassName()).getBeanDefinition();
                    String s = beanNameGenerator.generateBeanName(beanDefinition1, beanDefinitionRegistry);
                    beanDefinitionRegistry.registerBeanDefinition(s, beanDefinition);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
