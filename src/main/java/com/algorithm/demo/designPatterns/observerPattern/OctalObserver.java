package com.algorithm.demo.designPatterns.observerPattern;

/**
 * @author mahongbin
 * @date 2019/6/28 13:55
 * @Description
 */
public class OctalObserver extends Observer  {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "八位: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
