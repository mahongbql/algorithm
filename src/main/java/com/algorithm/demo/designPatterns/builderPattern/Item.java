package com.algorithm.demo.designPatterns.builderPattern;

import com.algorithm.demo.designPatterns.builderPattern.pack.Packing;

/**
 * @author mahongbin
 * @date 2019/6/21 15:11
 * @Description 定义主的食品抽象接口
 */
public interface Item {

    /**
     * 获取食品名字
     * @return
     */
    String name();

    /**
     * 食品的包装类型
     * @return
     */
    Packing packing();

    /**
     * 获取食品的价格
     * @return
     */
    float price();
}
