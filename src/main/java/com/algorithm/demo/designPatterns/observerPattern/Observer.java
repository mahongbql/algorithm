package com.algorithm.demo.designPatterns.observerPattern;

/**
 * @author mahongbin
 * @date 2019/6/28 13:51
 * @Description
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
