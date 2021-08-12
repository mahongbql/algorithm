package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-12 21:59
 * @Description: 剑指 Offer 49. 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 */
public class NthUglyNumber_49 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        int num2 = 1, num3 = 1, num5 = 1;
        for(int i = 1; i < n; i++) {
            int n2 = nums[num2] * 2;
            int n3 = nums[num3] * 3;
            int n5 = nums[num5] * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            if(min == n2) {
                num2++;
            }
            if(min == n3) {
                num3++;
            }
            if(min == n5) {
                num5++;
            }
            nums[i+1] = min;
        }
        return nums[n];
    }
}
