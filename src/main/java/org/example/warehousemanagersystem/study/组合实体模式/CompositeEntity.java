package org.example.warehousemanagersystem.study.组合实体模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class CompositeEntity {
    //创建颗粒度对象
    private CoarseGrainedObject cgo=new CoarseGrainedObject();
    //往颗粒度对象中塞入数据
    public void setData(String data1,String data2){
        cgo.setData(data1,data2);
    }
    //返回组合的字符串数组
    public String[] getData(){
        return cgo.getData();
    }
}
