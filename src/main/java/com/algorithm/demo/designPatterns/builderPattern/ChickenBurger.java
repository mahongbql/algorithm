package com.algorithm.demo.designPatterns.builderPattern;

import com.algorithm.demo.designPatterns.builderPattern.food.Burger;

/**
 * @author mahongbin
 * @date 2019/6/21 17:30
 * @Description
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
