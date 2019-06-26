package com.algorithm.demo.designPatterns.interpreterPattern.notRole;

import com.algorithm.demo.designPatterns.interpreterPattern.Context;
import com.algorithm.demo.designPatterns.interpreterPattern.Expression;

/**
 * @author mahongbin
 * @date 2019/6/26 17:55
 * @Description
 */
public class Subtract extends Expression {
    private Expression left , right ;
    public Subtract(Expression left , Expression right) {
        this.left = left ;
        this.right= right ;
    }

    @Override
    public int interpret(Context con) {
        return left.interpret(con) - right.interpret(con);
    }
}
