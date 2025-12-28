package org.example.warehousemanagersystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A02Application {
    private static final Logger log = LoggerFactory.getLogger(A02Application.class);

    public static void main(String[] args) {
        //  testClassPathXmlApplicationContext();
        // testFileSystemXmlApplicationContext();
//        testAnnotationConfigApplicationContext();
        testAnnotationConfigServletWebServerApplicationContext();
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        for (String name : beanFactory.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
//        //读取xml
//        System.out.println("-------------------");
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        int i = reader.loadBeanDefinitions(new ClassPathResource("b01.xml"));
//        for (String name : beanFactory.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

    }

    //从xml格式的配置文件来创建
    private static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("b01.xml");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }

    private static void testFileSystemXmlApplicationContext() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\77354\\Desktop\\demo-sq_2025_12_2\\src\\main\\resources\\b01.xml");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }

    private static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conifg.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println(context.getBean(Bean2.class).getBean1());
    }
    private static void testAnnotationConfigServletWebServerApplicationContext() {
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

    }
    @Configuration
    static  class  WebConfig{
       @Bean
        public  ServletWebServerFactory servletWebServerFactory(){
           return new  TomcatServletWebServerFactory();
       }
       //前控制器
       @Bean
        public DispatcherServlet dispatcherServlet(){
           return new DispatcherServlet();
       }
       @Bean
        public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet){
           return  new DispatcherServletRegistrationBean(dispatcherServlet,"/");
       }
       @Bean("/hello")
        public Controller controller1(){
           return new Controller() {
               @Override
               public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
                   response.getWriter().write("Hello World");
                   return null;
               }
           };
       }

    }
   @Configuration
    static class Conifg{
        @Bean
       public Bean1 bean1(){
            return new Bean1();
        }
        @Bean
       public Bean2 bean2(Bean1 bean1){
            Bean2 bean2 = new Bean2();
            bean2.setBean1(bean1);
            return bean2;
        }
    }

    static class Bean1 {

    }

    static class Bean2 {
        private Bean1 bean1;

        public void setBean1(Bean1 bean1) {
            this.bean1 = bean1;
        }

        public Bean1 getBean1() {
            return bean1;
        }
    }
}
