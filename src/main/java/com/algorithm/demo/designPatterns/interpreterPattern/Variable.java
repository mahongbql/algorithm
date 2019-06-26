package com.algorithm.demo.designPatterns.interpreterPattern;

/**
 * @author mahongbin
 * @date 2019/6/26 17:21
 * @Description
 */
public class Variable extends Expression {

    @Override
    public int interpret(Context con) {
        //this 为调用interpret 方法的Variable 对象
        return con.LookupValue(this);
    }
}
