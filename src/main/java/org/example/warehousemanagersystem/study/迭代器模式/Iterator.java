package org.example.warehousemanagersystem.study.迭代器模式;

/**
 * 允许顺序访问一个聚合对象中的元素，同时不暴露对象的内部表示。
 */
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
