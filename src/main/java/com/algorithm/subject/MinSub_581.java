package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-06 23:14
 * @Description:
 */
public class MinSub_581 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for(int i = 0; i < n; i++) {
            if(maxValue > nums[i]) {
                right = i;
            } else {
                maxValue = nums[i];
            }

            if(minValue < nums[n - 1 - i]) {
                left = n - 1 - i;
            } else {
                minValue = nums[n - 1 - i];
            }
        }

        return left == -1 ? 0 : right - left + 1;
    }
}
