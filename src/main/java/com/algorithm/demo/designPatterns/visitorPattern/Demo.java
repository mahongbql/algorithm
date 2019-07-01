package com.algorithm.demo.designPatterns.visitorPattern;

import com.algorithm.demo.designPatterns.visitorPattern.student.XueZha;
import com.algorithm.demo.designPatterns.visitorPattern.student.Xueba;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mahongbin
 * @date 2019/7/1 17:17
 * @Description
 */
public class Demo {
    public static void main(String[] args) {

        // 班级学生，只有学霸和学渣两种类型
        List<Student> students = new ArrayList<>();
        students.add(new Xueba());
        students.add(new XueZha());

        // 先确定访问方式，“出成绩”
        Visitor v = new ReleaseScoreVisitor();

        // 学生s接受v方式的访问
        for(Student s: students){
            s.accept(v);
        }
    }
}
