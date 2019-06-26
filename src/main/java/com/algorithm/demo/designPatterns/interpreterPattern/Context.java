package com.algorithm.demo.designPatterns.interpreterPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mahongbin
 * @date 2019/6/26 17:15
 * @Description
 */
public class Context {
    private Map valueMap = new HashMap();

    public void addValue(Variable x , int y){
        Integer yi = new Integer(y);
        valueMap.put(x , yi);
    }

    public int LookupValue(Variable x){
        int i = ((Integer)valueMap.get(x)).intValue();
        return i ;
    }
}
