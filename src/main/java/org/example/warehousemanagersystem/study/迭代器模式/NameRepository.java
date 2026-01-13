package org.example.warehousemanagersystem.study.迭代器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class NameRepository implements Container {
    //数据
    public String[] names={"Robert","John","Julie","Lora"};
    //生成一个NameIterator类
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        //位置
        private int index=0;
        //位置小于名字数组长度成功
        public boolean hasNext(){
            if(index<names.length){
                return true;
            }
            return false;
        }
        public Object next(){
            //遍历
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
