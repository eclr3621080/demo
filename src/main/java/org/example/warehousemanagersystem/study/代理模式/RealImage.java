package org.example.warehousemanagersystem.study.代理模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class RealImage implements  Image{
    private String fileName;
    //塞入名称
    public RealImage(String fileName) {
        this.fileName = fileName;

    }
    //实现
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);

    }
    //展示塞入的数据
    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
