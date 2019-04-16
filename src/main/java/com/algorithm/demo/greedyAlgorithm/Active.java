package com.algorithm.demo.greedyAlgorithm;

/**
 * @author mahongbin
 * @date 2019/4/15 16:42
 * @Description
 */
class Active implements Comparable<Active>{

    private int startTime;
    private int endTime;

    public Active(int startTime, int endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    @Override
    public String toString(){
        return "Active [startTime = "+ startTime +" , endTime = " + endTime + " ]";
    }

    /**
     * 按照结束时间升序，最早结束时间排在最前面
     * @param o
     * @return
     */
    @Override
    public int compareTo(Active o) {
        if(this.endTime>o.getEndTime()){
            return 1;
        }else if(this.endTime == o.endTime){
            return 0;
        }else{
            return -1;
        }
    }
}
