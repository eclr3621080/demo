package org.example.warehousemanagersystem.study.过滤器模式;

import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(personList);
        List<Person> otherCriteriaPersons = otherCriteria.meetCriteria(personList);

        for (Person person : otherCriteriaPersons) {
            if (!firstCriteriaPersons.contains(person)) {
                firstCriteriaPersons.add(person);
            }
        }
        return firstCriteriaPersons;
    }
}
