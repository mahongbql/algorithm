package com.algorithm.demo.designPatterns.visitorPattern.student;

import com.algorithm.demo.designPatterns.visitorPattern.Student;
import com.algorithm.demo.designPatterns.visitorPattern.Visitor;

/**
 * @author mahongbin
 * @date 2019/7/1 16:51
 * @Description
 */
public class XueZha extends Student {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitXueZha(this);
    }
}
