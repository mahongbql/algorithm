package com.algorithm.subject;

import java.util.*;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-04 22:47
 * @Description:
 * 公交路线：起始路线到终止路线最少乘坐的公交数量
 * route = {{1,2},{2,3}.{3,4}}
 * start = 1, end = 4
 * route二维数组中一个数组代表一辆公交车，其中数字代表站点，start表示起始站，end代表终止站点
 * result = 3 （代表从1到4需要乘坐3辆公交车）
 *
 * 例2：
 * route = {{1,2,3},{3,5,6}}
 * start = 1, end = 6
 * result = -1
 */
public class BusRoute_815 {
    public static void main(String[] args) {
        int[][] busRoute = {{2,5,6},{3,6,8}};
        int start = 2;
        int end = 8;
        System.out.println(minBusRoute(busRoute, start, end));
    }

    static int minBusRoute(int[][] busRoute, int start, int end) {
        int routeNum = busRoute.length;
        if(routeNum == 0) return -1;

        //记录各个站点对应经过的路线集合
        Map<Integer, List<Integer>> stops = new HashMap<>();

        //记录各个路线的交集
        boolean[][] routeRelationship = new boolean[routeNum][routeNum];

        //开始填充上述两个集合
        for(int i = 0; i < routeNum; i++) {
            for(int stop : busRoute[i]) {
                List<Integer> routes = stops.get(stop);
                //包含当前站点，那么建立当前站点
                if(stops.containsKey(stop)) {
                    for(int s : routes) {
                        routeRelationship[i][s] = true;
                        routeRelationship[s][i] = true;
                    }
                } else {
                    stops.put(stop, new ArrayList<>());
                }
                stops.get(stop).add(i);
            }
        }

        //站点没有起始站和终止站
        if(!stops.containsKey(start) || !stops.containsKey(end)) return -1;

        //到达该线路所需要的公交数
        int[] busNum = new int[routeNum];

        Queue<Integer> que = new LinkedList<>();
        for(int route : stops.get(start)) {
            que.offer(route);
            busNum[route] = 1;
        }

        //说明有起始站也有终点站，目的是将num填充对应数字到busNum中
        int num = 2;
        while(!que.isEmpty()) {
            int pop = que.poll();
            for(int i = 0; i < routeNum; i++) {
                if(busNum[i] == 0 && routeRelationship[pop][i]) {
                     busNum[i] = num;
                     que.offer(i);
                }
            }
            num++;
        }

        int rtnBusNum = Integer.MAX_VALUE;
        List<Integer> endList = stops.get(end);
        for(int route : endList) {
            rtnBusNum = Math.min(rtnBusNum, busNum[route]);
        }

        return rtnBusNum == Integer.MAX_VALUE ? -1 : rtnBusNum;
    }
}
