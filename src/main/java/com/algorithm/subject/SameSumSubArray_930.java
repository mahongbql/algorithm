package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-08 21:03
 * @Description: 和相同二元子数组
 *
 * 例1：num = [1,0,1,0,1]
 *    goal = 2
 *    result: 4   ->  [1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 *
 * 例2：num = [0,0,0,0,0]
 *    goal = 0
 *    result: 15
 *
 */
public class SameSumSubArray_930 {
    public static void main(String[] args) {
        int[] num = {1,0,1,0,1};
        int goal = 2;

        int result = 0;
        for(int i = 0; i < num.length; i++) {
            int sum = num[i];
            if(sum == goal) result++;
            for(int j = i+1; j < num.length; j++) {
                sum += num[j];
                if(sum == goal) result++;
            }
        }

        System.out.println(result);
    }
}
