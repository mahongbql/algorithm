package com.algorithm.demo.designPatterns.observerPattern;

/**
 * @author mahongbin
 * @date 2019/6/28 14:02
 * @Description
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "哈希值: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
