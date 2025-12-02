//package org.example.warehousemanagersystem.study.视图解析机制;
//
//import org.springframework.web.servlet.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Locale;
//import java.util.Map;
//
///**
// * @Author: 沈琪
// * @CreateTime: 2025-11-20
// * @Description:
// * @Version: 1.0
// */
//
//
//// 继承自 FrameworkServlet 的 DispatcherServlet 类，作为前端控制器
//public class DispatcherServlet {
//
//    // 前端控制器的核心方法，处理请求，返回视图，渲染视图，都是在这个方法中完成的。
//
//    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        // 假设这里有对请求进行预处理
//        HttpServletRequest processedRequest = request;
//
//        // 模拟处理器适配器和映射处理器
//        HandlerAdapter ha = new SimpleHandlerAdapter();
//        HandlerExecutionChain mappedHandler = new HandlerExecutionChain(new SimpleController());
//// 根据请求路径调用映射的处理器方法，处理器方法执行结束之后，返回逻辑视图名称
//        // 返回逻辑视图名称之后，DispatcherServlet会将 逻辑视图名称ViewName + Model，将其封装为ModelAndView对象。
//        ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
//        // 这行代码的作用是处理视图
//        processDispatchResult(processedRequest, response, mappedHandler, mv, null);
//    }
//    private void processDispatchResult(HttpServletRequest request, HttpServletResponse response,
//                                       HandlerExecutionChain mappedHandler, ModelAndView mv,
//                                       Exception dispatchException) throws Exception {
//        // 渲染页面（将模板字符串转换成html代码响应到浏览器）
//        render(mv, request, response);
//    }
//
//    protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String viewName = mv.getViewName();
//        // 这个方法的作用是将 逻辑视图名称 转换成 物理视图名称 ，并且最终返回视图对象View
//        View view = resolveViewName(viewName, mv.getModelInternal(), Locale.getDefault(), request);
//
//        // 真正的将模板字符串转换成HTML代码，并且将HTML代码响应给浏览器。（真正的渲染。）
//        view.render(mv.getModelInternal(), request, response);
//    }
//    protected View resolveViewName(String viewName, Map<String, Object> model,
//                                   Locale locale, HttpServletRequest request) throws Exception {
//        // 其实这一行代码才是真正起作用的：将 逻辑视图名称 转换成 物理视图名称 ，并且最终返回视图对象View
//        ViewResolver viewResolver = new SimpleViewResolver();
//        // 如果使用的是Thymeleaf，那么返回的视图对象：ThymeleafView对象。
//        View view = viewResolver.resolveViewName(viewName, locale);
//
//        return view;
//    }
//
//}
