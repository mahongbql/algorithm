package com.algorithm.demo.designPatterns.interpreterPattern;

/**
 * @author mahongbin
 * @date 2019/6/26 17:20
 * @Description 终结符表达式角色
 */
public class Constant extends Expression {
    private int i ;
    public Constant(int i){
        this.i = i;
    }

    @Override
    public int interpret(Context con){
        return i ;
    }
}
