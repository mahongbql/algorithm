package com.algorithm.subject;

import java.util.*;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-02 22:56
 * @Description:
 */
public class NetDelay_743 {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int workDelayTime = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] time : times) {
            int start = time[0];
            int end = time[1];
            int delay = time[2];

            List<int[]> list = map.getOrDefault(start, new ArrayList<>());
            int[] arr = {end, delay};
            list.add(arr);

            map.put(start, list);
        }

        List<int[]> list = map.get(k);
        if(null == list) return -1;

        int max = 0;
        for(int[] arr : list) {
            workDelayTime = 0;
            int next = arr[0];
            int delay = arr[1];

            workDelayTime += delay;
            max = Math.max(max, workDelayTime);
        }

        return workDelayTime;
    }
}
