package com.algorithm.demo.designPatterns.builderPattern.food;

import com.algorithm.demo.designPatterns.builderPattern.Item;
import com.algorithm.demo.designPatterns.builderPattern.pack.Packing;
import com.algorithm.demo.designPatterns.builderPattern.pack.Wrapper;

/**
 * @author mahongbin
 * @date 2019/6/21 15:36
 * @Description 抽象类封装好肯定不会变的，留下灵活变化的可以自定义
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
