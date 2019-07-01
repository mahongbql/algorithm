package com.algorithm.demo.designPatterns.visitorPattern;

/**
 * @author mahongbin
 * @date 2019/7/1 16:55
 * @Description
 */
public abstract class Student {
    public abstract void accept(Visitor visitor);
}
