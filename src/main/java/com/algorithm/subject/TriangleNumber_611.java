package com.algorithm.subject;

import java.util.Arrays;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-07 14:38
 * @Description:
 */
public class TriangleNumber_611 {
    public static void main(String[] args) {
        int[] nums = {25,61,78,38,19,80,78,57,48,70,91,58,79,16,67,85,17,10,0,52,41,36,32,42,86,66,32,63,31,51,6,100,50,32,43,34,99,22,93,55,88,14,50,17,86,23,7,29,28,76,30,0,31,24,14,27,17,69,64,14,81,45,59,21,31,39,85,0,71,77,73,91,38,48,6,91,41,42,14,7,29,43,21,56,23,58,44,18,48,22,76,34,28,3,11,4,2,79,19,92};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int k = j + 1;
                while(k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                ans += (k-j-1);
            }
        }
        return ans;
    }
}
