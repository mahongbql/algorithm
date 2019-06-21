package com.algorithm.demo.designPatterns.builderPattern;

import com.algorithm.demo.designPatterns.builderPattern.food.ColdDrink;

/**
 * @author mahongbin
 * @date 2019/6/21 17:29
 * @Description
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 12.5f;
    }
}
