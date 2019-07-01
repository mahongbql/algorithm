package com.algorithm.demo.designPatterns.visitorPattern;

import com.algorithm.demo.designPatterns.visitorPattern.student.XueZha;
import com.algorithm.demo.designPatterns.visitorPattern.student.Xueba;

/**
 * @author mahongbin
 * @date 2019/7/1 16:50
 * @Description 当前访问方式为 分数 访问方式，定义其他多变的活动访问方式可以再定义其他类继承 Visitor 接口
 */
public class ReleaseScoreVisitor implements Visitor {
    @Override
    public void visitXueBa(Xueba x) {
        System.out.println("出成绩了，开心");
    }

    @Override
    public void visitXueZha(XueZha x) {
        System.out.println("出成绩了，不开心");
    }
}
