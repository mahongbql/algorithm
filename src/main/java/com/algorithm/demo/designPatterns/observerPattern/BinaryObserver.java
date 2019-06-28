package com.algorithm.demo.designPatterns.observerPattern;

/**
 * @author mahongbin
 * @date 2019/6/28 13:52
 * @Description
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        //将当前类加入到监控列表中
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "二进制字符串: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
