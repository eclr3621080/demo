//package org.example.warehousemanagersystem.springboot的启动流程;
//
//
//import org.apache.catalina.Loader;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
//import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
//import org.springframework.beans.factory.config.BeanDefinitionHolder;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.AutowireCandidateQualifier;
//import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
//import org.springframework.boot.*;
//import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
//import org.springframework.boot.context.event.ApplicationPreparedEvent;
//import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
//import org.springframework.boot.env.EnvironmentPostProcessor;
//import org.springframework.boot.env.RandomValuePropertySource;
//import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
//import org.springframework.context.*;
//import org.springframework.context.annotation.AnnotationConfigUtils;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.ScopeMetadata;
//import org.springframework.core.annotation.AnnotationAwareOrderComparator;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.StandardEnvironment;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//import org.springframework.util.StopWatch;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.support.StandardServletEnvironment;
//
//import java.lang.annotation.Annotation;
//import java.security.AccessControlException;
//import java.util.*;
//import java.util.function.Supplier;
//
//
///**
// * @Author: 沈琪
// * @CreateTime: 2025-12-02
// * @Description:
// * @Version: 1.0
// */
//
//
//public class SpringApplication {
//    private org.springframework.core.io.ResourceLoader resourceLoader;
//    private Set<Class<?>> primarySources;
//    private WebApplicationType webApplicationType;
//    private Class<?> mainApplicationClass;
//
//    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
//        return new org.springframework.boot.SpringApplication(primarySources).run(args);
//    }
//
//    //获取监听器
//    private SpringApplicationRunListeners getRunListeners(String[] args) {
//        Class<?>[] types = new Class<?>[]{SpringApplication.class, String[].class};
//        return new SpringApplicationRunListeners(logger,
//                getSpringFactoriesInstances(SpringApplicationRunListener.class, types, this, args));
//    }
//
//    //环境变量的构造
//    private ConfigurableEnvironment prepareEnvironment(SpringApplicationRunListeners listeners, ApplicationArguments applicationArguments) {
//        // Create and configure the environment
//        // 获取或者创建 environment。这里获取类型是 StandardServletEnvironment
//        ConfigurableEnvironment environment = getOrCreateEnvironment();
//        // 将入参配置到环境配置中
//        configureEnvironment(environment, applicationArguments.getSourceArgs());
//        ConfigurationPropertySources.attach(environment);
//        // 发布环境准备事件。
//        listeners.environmentPrepared(environment);
//        bindToSpringApplication(environment);
//        if (!this.isCustomEnvironment) {
//            environment = new EnvironmentConverter(getClassLoader()).convertEnvironmentIfNecessary(environment,
//                    deduceEnvironmentClass());
//        }
//        ConfigurationPropertySources.attach(environment);
//        return environment;
//    }
//
//    private Class<? extends StandardEnvironment> deduceEnvironmentClass() {
//        switch (this.webApplicationType) {
//            case SERVLET:
//                return StandardServletEnvironment.class;
//            case REACTIVE:
//                return StandardReactiveWebEnvironment.class;
//            default:
//                return StandardEnvironment.class;
//        }
//    }
//
//    public ConfigurableApplicationContext run(String... args) {
//        // 开启关于启动时间的信息监控
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        //准备 ApplicationContext
//        ConfigurableApplicationContext context = null;
//        Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
//        //java.awt.headless 是J2SE的一种模式用于在缺少显示屏、键盘或者鼠标时的系统配置，很多监控工具入jconsole需要将该值设置为true，系统变量默认为true
//        configureHeadlessProperty();
//        //1、获取Spring的监听器类，这里时从spring.factories中去获取，默认的是以org.springframework.boot.SpringApplicationRunListener
//        // 为key,获取到的监听器类型为 EventPublishingRunListener。
//        SpringApplicationRunListeners listeners = getRunListeners(args);
//        //1.1监听器发送启动事件
//        listeners.starting();
//        try {
//            //封装参数
//            ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
//            // 2.构造容器环境。讲容器的一些配置内容加载到environment中 这一步的作用就是加载一些配置文件的内容
//            ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
//            //配置BeanInfo的忽略："Spring.beaninfo.ignore",值为true标识跳过对BeanInfo类搜索
//            configureIgnoreBeanInfo(environment);
//            // 打印信息对象
//            Banner printedBanner = printBanner(environment);
//            // 3. 创建上下文对象
//            context = createApplicationContext();
//            // 从 spring.factries 中获取错误报告的类。出错的时候会调用其方法通知
//            exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
//                    new Class[]{ConfigurableApplicationContext.class}, context);
//            // 4. 准备刷新上下文
//            prepareContext(context, environment, listeners, applicationArguments, printedBanner);
//            // 5. 刷新上下文
//            refreshContext(context);
//            // 结束刷新，留待扩展功能，并未实现什么
//            afterRefresh(context, applicationArguments);
//            // 停止监听
//            stopWatch.stop();
//            if (this.logStartupInfo) {
//                new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
//            }
//            // 监听器发送启动结束时间
//            listeners.started(context);
//            // 调用 ApplicationRunner 和 CommandLineRunner 对应的方法
//            callRunners(context, applicationArguments);
//        } catch (Throwable ex) {
//            handleRunFailure(context, ex, exceptionReporters, listeners);
//            throw new IllegalStateException(ex);
//        }
//        try {
//            // 发送容器运行事件
//            listeners.running(context);
//        } catch (Throwable ex) {
//            handleRunFailure(context, ex, exceptionReporters, null);
//            throw new IllegalStateException(ex);
//        }
//        return context;
//    }
//    //2.1application.yml 的加载
//    //在 listeners.environmentPrepared(environment); 时会发送环境准备事件，环境准备事件要通知七个监听器
//    //对于 Springboot 的配置文件application.yml或者application.properties文件的加载实际上是通过发布环境准备事件完成的，
//    // 完成这项功能的就是 ConfigFileApplicationListener
//    //七个监听器
//    //ConfigFileApplicationListener
//    //AnsiOutputApplicationListener
//    //LoggingApplicationListener
//    //ClasspathLoggingApplicationListener
//    //BackgroundPreinitializer
//    //DelegatingApplicationListener
//    //FileEncodingApplicationListener
//
//    public void onApplicationEvent(ApplicationEvent event) {
//        if (event instanceof ApplicationEnvironmentPreparedEvent) {
//            onApplicationEnvironmentPreparedEvent((ApplicationEnvironmentPreparedEvent) event);
//        }
//        if (event instanceof ApplicationPreparedEvent) {
//            onApplicationPreparedEvent(event);
//        }
//    }
//
//    public void environmentPrepared(ConfigurableEnvironment environment) {
//        this.initialMulticaster.multicastEvent(new ApplicationEnvironmentPreparedEvent(this.application, this.args, environment));
//
//    }
//
//    private void onApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event) {
//        //获取EnvironmentPostProcessor。这里也是spring.factories 文件中获取
//        List<EnvironmentPostProcessor> postProcessors = loadPostProcessors();
//        //把自身添加进去
//        postProcessors.add(this);
//        AnnotationAwareOrderComparator.sort(postProcessors);
//        //排序后调用EnvironmentPostProcessor#postProcessEnvironment 方法
//        for (EnvironmentPostProcessor postProcessor : postProcessors) {
//            postProcessor.postProcessEnvironment(event.getEnvironment(), event.getSpringApplication());
//        }
//    }
//
//    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
//        addPropertySources(environment, application.getResourceLoader());
//    }
//
//    protected void addPropertySources(ConfigurableEnvironment environment, ResourceLoader resourceLoader) {
//        RandomValuePropertySource.addToEnvironment(environment);
//        // 在这里面的load方法中加载了配置文件内容。具体就不再解析
//        new Loader(environment, resourceLoader).load();
//    }
//    //AnnotationConfigServletWebServerApplicationContext
//    // 构造函数中会创建 AnnotatedBeanDefinitionReader。
//    // 而在 AnnotatedBeanDefinitionReader 构造函数中会调用
//    // AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry);，
//    // 该方法将一些必要Bean(如ConfigurationClassPostProcessor、
//    // AutowiredAnnotationBeanPostProcessor、CommonAnnotationBeanPostProcessor 等)注入到了容器中
//
//    //上下文准备工作
//    //prepareContext(context, environment, listeners, applicationArguments, printedBanner);
//    private void prepareContext(ConfigurableApplicationContext context, ConfigurableEnvironment environment,
//                                SpringApplicationRunListeners listeners, ApplicationArguments applicationArguments, Banner printedBanner) {
//        //设置上下文的环境变量
//        context.setEnvironment(environment);
//        //执行容器后置处理：可以注册beanName 策略生成器、设置资源加载器、设置转换服务等。但这里默认是没有做任何处理。目的是留给后续可以扩展
//        postProcessApplicationContext(context);
//        //处理所有的初始化类的初始化方法。即spring。factories中key 为org.springframework.context.ApplicationContextInitializer 指向的类，调用其 initialize 方法
//        applyInitializers(context);
//        //向监听器发送容器准备事件
//        listeners.contextPrepared(context);
//        if (this.logStaruoInfo){
//            logStartupInfo(context.getParent()==null);
//            logStartupProfileInfo(context);
//        }
//        //Add boot specific singleton beans
//        //获取上下文中的BeanFactory。这里的BeanFactory 实际类型是  DefaultListableBeanFactory。
//        // BeanFactory 在初始化的时候，直接在构造函数里创建为 DefaultListableBeanFactory
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        //注册springApplicationArguments等一系列bean
//        beanFactory.registerSingleton("springApplicationArguments",applicationArguments);
//        if (printedBanner != null) {
//            beanFactory.registerSingleton("springBootBanner", printedBanner);
//        }
//        if (beanFactory instanceof ConfigurableListableBeanFactory) {
//            ((ConfigurableListableBeanFactory) beanFactory).setAllowBeanDefinitionOverriding(this.allowBeanDefinitionOverriding);
//        }
//        //如果允许懒加载，则添加对应的BeanFactory后置处理器
//        if (this.lazyInitialization){
//            context.addBeanFactoryPostProcessor(new LazyInitializationBeanFactoryPostProcessor());
//        }
//        // Load the sources
//        // 这里加载的实际上是启动类
//        Set<Object> sources = getAllSources();
//        Assert.notEmpty(sources, "Sources must not be empty");
//        // 这里将启动类加入到 beanDefinitionMap 中，为后续的自动化配置做好了基础
//        load(context, sources.toArray(new Object[0]));
//        // 发送容器加载完成事件
//        listeners.contextLoaded(context);
//    }
//    protected void load(ApplicationContext context, Object[] sources) {
//        if (logger.isDebugEnabled()) {
//            logger.debug("Loading source"+ StringUtils.arrayToCommaDelimitedString(sources));
//        }
//        //从上下文中获取BeanDefinitionRegistry 并依次创建出BeanDefinitionLoader。
//        // 这里将sources作为参数保存到了 loader  中。也就是 loader  中保存了 启动类的Class信息
//        BeanDefinitionLoader loader = createBeanDefinitionLoader(getBeanDefinitionRegistry(context), sources);
//        if (this.beanNameGenerator!=null){
//            loader.setBeanNameGenerator(this.beanNameGenerator);
//        }
//        if (this.resourceLoader != null) {
//            loader.setResourceLoader(this.resourceLoader);
//        }
//        if (this.environment != null) {
//            loader.setEnvironment(this.environment);
//        }
//        loader.load();
//    }
//    private int load(Class<?> source){
//        //判断是否存在groovy加载方式
//        if (isGroovyPresent() && GroovyBeanDefinitionSource.class.isAssignableFrom(source)) {
//            // Any GroovyLoaders added in beans{} DSL can contribute beans here
//            GroovyBeanDefinitionSource loader = BeanUtils.instantiateClass(source, GroovyBeanDefinitionSource.class);
//            load(loader);
//        }
//        // 判断 source 是否 需要被加载到Spring容器中。实际上是根据判断是否存在 @Component
//        if (isComponent(source)) {
//            // 将source 就是启动类的 class，注册到 annotatedReader 中。annotatedReader  类型是AnnotatedBeanDefinitionReader。
//            this.annotatedReader.register(source);
//            return 1;
//        }
//        return 0;
//    }
//    //this.annotatedReader.register(source); 后续会跳转到
//    // AnnotatedBeanDefinitionReader#doRegisterBean 方法中，
//    // 看名字就知道是这个方法的工作是 注册 Bean。实际上，在这个方法中完成了对@Qualifier 以及一些其他注解的处理。具体如下：
//    // 这里的 beanClass 其实就是启动类的 beanClass
//    private <T> void doRegisterBean(Class<T> beanClass, @Nullable String name,
//                                    @Nullable Class<? extends Annotation>[] qualifiers, @Nullable Supplier<T> supplier,
//                                    @Nullable BeanDefinitionCustomizer[] customizers) {
//        //将class 转换成一个BeanDefinition 类
//        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
//        //判断是否一个跳过
//        if (this.conditionEvaluator.shouldSkip(abd.getMetadata())) {
//            return;
//        }
//        abd.setInstanceSupplier(supplier);
//        // 保存其作用域信息。这里默认是 singleton
//        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
//        abd.setScope(scopeMetadata.getScopeName());
//        //获取beanName
//        String beanName=(name !=null? name: this.beanNameGenerator.generateBeanName(abd,this.registry));
//        // 处理一些通用的注解信息，包括Lazy、Primary、DependsOn、Role、Description 注解。获取其value值并保存到 abd 中
//        AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);
//        //处理 @Qualifier
//        if(qualifiers!=null){
//            for (Class<? extends Annotation> qualifier : qualifiers) {
//                if(Primary.class==qualifier){
//                    abd.setPrimary(true);
//                }
//                else if (Lazy.class==qualifier){
//                    abd.setLazyInit(true);
//                }else {
//                    abd.addQualifier(new AutowireCandidateQualifier(qualifier));
//                }
//            }
//        }
//        if (customizers!=null) {
//            for (BeanDefinitionCustomizer customizer : customizers) {
//                customizer.customize(abd);
//            }
//        }
//        BeanDefinitionHolder definitionHolder  = new BeanDefinitionHolder(abd, beanName);
//        // 判断是否需要创建代理，需要则创建
//        definitionHolder=AnnotationConfigUtils.applyScopedProxyMode(scopeMetadata,definitionHolder,this.registry);
//        // 将 BeanDefinitionHolder  注册到 容器中。
//        // 此时的 registry 就是 AnnotationConfigServletWebServerApplicationContext。在BeanDefinitionLoader 初始化的时候保存的
//        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, this.registry);
//
//    }
//    //对容器进行一个刷新工作。在此进行了大量的工作。这里的处理工作就由Springboot交给 Spring来处理了
//    private void refreshContext(ConfigurableApplicationContext  context){
//        refresh(context);
//        if (this.registerShutdownHook){
//            try{
//                context.registerShutdownHook();
//            }catch (AccessControlException ex){
//
//            }
//        }
//    }
//
//}
