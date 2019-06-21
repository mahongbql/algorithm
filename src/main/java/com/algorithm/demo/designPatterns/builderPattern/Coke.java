package com.algorithm.demo.designPatterns.builderPattern;

import com.algorithm.demo.designPatterns.builderPattern.food.ColdDrink;

/**
 * @author mahongbin
 * @date 2019/6/21 17:16
 * @Description
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
