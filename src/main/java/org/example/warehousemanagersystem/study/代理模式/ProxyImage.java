package org.example.warehousemanagersystem.study.代理模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;
    //塞入数据
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    public void getRealImage(RealImage  realImage) {
        this.realImage = realImage;
    }
    @Override
    public void display() {
        //如果realImage没数据，则把proxyimage的数据塞入，然后用realimage的实现累去实现
        if (realImage==null){
            realImage=new RealImage(fileName);
        }
        realImage.display();
    }
}
