package com.algorithm.interview;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        return find(0, nums, 0);
    }

    public static int find(int cur, int[] nums, int step) {
        if(cur >= nums.length-1) {
            return step;
        }

        int num = nums[cur];
        int max_num = 0;
        int max_index = 0;
        for(int i = cur+1; i < cur+num+1; i++) {
            if(nums[i] > max_num) {
                max_num = nums[i];
                max_index = i;
            }
        }

        cur = max_index;

        return find(cur, nums, step+1);
    }
}
