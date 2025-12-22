package org.example.warehousemanagersystem.study.过滤器模式;

import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
       List<Person> firstCriteriaPersons = criteria.meetCriteria(personList);
       return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
