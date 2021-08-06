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
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for(int[] time : times) {
            List<Integer[]> list = map.getOrDefault(time[0], new ArrayList<>());
            Integer[] ints = {time[1], time[2]};
            list.add(ints);
            map.put(time[0], list);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        boolean[] visted = new boolean[n+1];

        while(true) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 1; i <= n; i++) {
                if(!visted[i] && distance[i] < minValue) {
                    minValue = distance[i];
                    minIndex = i;
                }
            }

            if(minIndex == -1) break;
            visted[minIndex] = true;

            for(int i = 1; i <= n; i++) {
                if(map.containsKey(minIndex))
                    for(Integer[] ints : map.get(minIndex))
                        distance[ints[0]] = Math.min(distance[ints[0]], minValue + ints[1]);
            }
        }

        int maxValue = 0;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) return -1;
            maxValue = Math.max(distance[i], maxValue);
        }
        return maxValue;
    }
}
