package com.algorithm.demo.designPatterns.interpreterPattern;

/**
 * @author mahongbin
 * @date 2019/6/26 17:19
 * @Description 抽象表达式角色，也可以用接口来实现
 */
public abstract class Expression {
    public abstract int interpret(Context con);
}
