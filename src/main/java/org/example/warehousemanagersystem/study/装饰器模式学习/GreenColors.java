package org.example.warehousemanagersystem.study.装饰器模式学习;

import cn.hutool.core.text.csv.CsvUtil;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-07
 * @Description:
 * @Version: 1.0
 */


public class GreenColors implements Color {
    @Override
    public void getColors() {
        System.out.println("实现了绿色");
    }
}
