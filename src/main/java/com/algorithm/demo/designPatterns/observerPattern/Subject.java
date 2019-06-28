package com.algorithm.demo.designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mahongbin
 * @date 2019/6/28 13:48
 * @Description 在state变化的时候会通知到每一个在list中的Observer，Observer为抽象类
 */
public class Subject {

    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
