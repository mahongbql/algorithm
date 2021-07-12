package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-11 19:01
 * @Description: 主要元素
 *
 * 要求时间复杂度O(n),空间复杂度O(1)
 * 例1:[1,2,5,9,5,9,5,5,5] -> result:5
 * 例2:[3,2] -> result:-1
 * 例3:[2,2,1,1,1,2,2] -> result:2
 *
 * 采用投票算法
 *
 */
public class mainElement_17_10 {

    public static void main(String[] args) {
        int[] nums = {3,2};

        int num = -1;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                num = nums[i];
            }
            if(num == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num) {
                count++;
            }
        }

        System.out.println((count * 2) > nums.length ? num : -1);
    }

}
