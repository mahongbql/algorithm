package com.algorithm.demo.designPatterns.builderPattern.food;

import com.algorithm.demo.designPatterns.builderPattern.Item;
import com.algorithm.demo.designPatterns.builderPattern.pack.Bottle;
import com.algorithm.demo.designPatterns.builderPattern.pack.Packing;

/**
 * @author mahongbin
 * @date 2019/6/21 17:05
 * @Description
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
