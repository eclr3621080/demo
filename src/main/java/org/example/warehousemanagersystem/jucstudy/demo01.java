package org.example.warehousemanagersystem.jucstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:
 * @Version: 1.0
 */

@Controller
public class demo01 {
    @Autowired
    ThreadDemo  threadDemo;

    @Autowired
    ThreadDemo1   threadDemo1;

    public static void main(String[] args) throws Exception {
        ThreadDemo  threadDemo=new ThreadDemo();
        threadDemo.start();
        new Thread(new ThreadDemo1()).start();
        ThreadDemo2   threadDemo2=new ThreadDemo2();
        String call = threadDemo2.call();
        System.out.println(call);
        HashMap<String, String> map = new HashMap<>();

    }

}
