package com.algorithm.demo.designPatterns.builderPattern;

import com.algorithm.demo.designPatterns.builderPattern.food.Burger;

/**
 * @author mahongbin
 * @date 2019/6/21 17:08
 * @Description
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "蔬菜汉堡";
    }

    @Override
    public float price() {
        return 23.5f;
    }
}
