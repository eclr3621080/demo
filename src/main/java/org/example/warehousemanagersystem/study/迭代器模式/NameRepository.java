package org.example.warehousemanagersystem.study.迭代器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class NameRepository implements Container {
    public String[] names={"Robert","John","Julie","Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        private int index=0;

        public boolean hasNext(){
            if(index<names.length){
                return true;
            }
            return false;
        }
        public Object next(){
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
