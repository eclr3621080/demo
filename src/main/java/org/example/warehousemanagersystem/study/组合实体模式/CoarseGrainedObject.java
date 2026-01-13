package org.example.warehousemanagersystem.study.组合实体模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:创建粗粒度对象。
 * @Version: 1.0
 */


public class CoarseGrainedObject {
    //创建实体对象
    DependentObject1 do1=new DependentObject1();
    DependentObject2 do2=new DependentObject2();
    //分别塞入不同数据
    public void setData(String data1,String data2){
        do1.setData(data1);
        do2.setData(data2);
    }
    //得到一个字符串数据，是两个实体类的数据
     public String[] getData(){
        return new String[]{do1.getData(),do2.getData()};
     }
}
