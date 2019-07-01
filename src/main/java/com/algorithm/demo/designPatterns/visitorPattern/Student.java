package com.algorithm.demo.designPatterns.visitorPattern;

/**
 * @author mahongbin
 * @date 2019/7/1 16:34
 * @Description 学生接口
 */
public interface Student {

    /**
     * 访问者包装经常变化的元素
     * @param visitor
     */
    void accept(Visitor visitor);
}
