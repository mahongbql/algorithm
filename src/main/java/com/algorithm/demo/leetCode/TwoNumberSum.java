package com.algorithm.demo.leetCode;

/**
 * @author mahongbin
 * @date 2019/10/25 11:02
 * @Description
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的 两个 数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] nums = {2, 2, 6, 8, 7, 11, 15};
        int target = 8;

        myDealSum(nums, target);
    }

    public static void myDealSum(int[] numSum, int target) {
        boolean s = false;
        for(int i = 0; i < numSum.length; i++) {
            for(int j = i + 1; j < numSum.length; j++) {
                if(numSum[i] + numSum[j] == target) {
                    System.out.println("[" + i + ", " + j + "]");
                    s = true;
                    break;
                }
            }
            if(s) {
                break;
            }
        }


    }
}
