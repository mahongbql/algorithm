package com.algorithm.demo.designPatterns.visitorPattern;

/**
 * @author mahongbin
 * @date 2019/7/1 16:37
 * @Description 访问者，需要实现 变化的元素，比如学生会 放假、春游、出成绩等事件频繁更改
 */
public interface Visitor {

    void visitXueBa(XueBa x);    // 访问学霸
    void visitXueZha(XueZha x);    // 访问学渣
}
