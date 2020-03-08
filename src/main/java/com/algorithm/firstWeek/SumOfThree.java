package com.algorithm.firstWeek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class SumOfThree {

    public static void main(String[] args) {
        //排好序之后 {-4, -1, -1, 0, 1, 2}
        int[] nums = {0,0,0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        //i = j + k   i,j,k
        for(int i = 0; i < nums.length - 2; i++) {
            //避免出现 nums[i] = nums[j] + nums[k] 与 nums[i+1] = nums[j] + nums[k] 重复
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1, target = 0 - nums[i];
            while(j < k) {
                //如果 i = j + k，表示满足条件
                if(target == nums[j] + nums[k]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //成功后防止nums[j]和nums[j+1]相同，
                    //在j++后造成nums[i] = nums[j] + nums[k] 与 nums[i] = nums[j+1] + nums[k]相同的计算
                    while (j<k && nums[j] == nums[j+1]) j++;
                    ///成功后防止nums[k]和nums[k-1]相同，
                    //在j++后造成nums[i] = nums[j] + nums[k] 与 nums[i] = nums[j+1] + nums[k-1]相同的计算
                    while (j<k && nums[k] == nums[k-1]) k--;
                    //这一轮循环完了，进行下一轮，下标移动
                    j++; k--;
                } else if(target > nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}
