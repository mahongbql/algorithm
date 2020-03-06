package com.algorithm.firstWeek;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Water {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOne(height));
//        System.out.println(myMaxArea(height));
    }

    private static int maxAreaOne(int[] height) {
        int water = 0;

        int i = 0, j = height.length - 1;
        while (i < j) {
            water = max(water, (j - i) * (min(height[i], height[j])));
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }

    private static int myMaxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int tmp = j - i;
                int num = 0;
                if(height[i] > height[j]) {
                    num = tmp * height[j];
                } else {
                    num = tmp * height[i];
                }


                if(num > max) {
                    max = num;
                }
            }
        }

        return max;
    }
}
