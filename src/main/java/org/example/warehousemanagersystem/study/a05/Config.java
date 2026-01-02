package org.example.warehousemanagersystem.study.a05;

import cn.hutool.db.ds.druid.DruidDSFactory;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.warehousemanagersystem.study.a05.component.Bean2;
import org.example.warehousemanagersystem.study.a05.mapper.Mapper1;
import org.example.warehousemanagersystem.study.a05.mapper.Mapper2;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example.warehousemanagersystem.study.a05.component")
public class Config {
    public Bean2 bean2(){
        return new Bean2();
    }
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean(initMethod = "init")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public MapperFactoryBean<Mapper1> mapper1( SqlSessionFactory sqlSessionFactory){
        MapperFactoryBean<Mapper1> mapperFactoryBean = new MapperFactoryBean<>(Mapper1.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
       return mapperFactoryBean;
    }
//    @Bean
//    public MapperFactoryBean<Mapper2> mapper2(SqlSessionFactory sqlSessionFactory){
//        MapperFactoryBean<Mapper2> mapperFactoryBean = new MapperFactoryBean<>(Mapper2.class);
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapperFactoryBean;
//    }


}
