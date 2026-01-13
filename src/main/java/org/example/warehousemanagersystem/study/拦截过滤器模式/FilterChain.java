package org.example.warehousemanagersystem.study.拦截过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-12
 * @Description:
 * @Version: 1.0
 */


public class FilterChain {
    private List<Filter> filters=new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter:filters){
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target=target;
    }

}
