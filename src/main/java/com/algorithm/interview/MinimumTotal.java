package com.algorithm.interview;

/**
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 *
 * Example
 * 样例 1
 *
 * 输入下列数字三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 输出： 11
 * 解释： 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 * 样例 2
 *
 * 输入下列数字三角形：
 * [
 *      [2],
 *     [3,2],
 *    [6,5,7],
 *   [4,4,8,1]
 * ]
 * 输出： 12
 * 解释： 从顶到底部的最小路径和为12 ( 2 + 2 + 7 + 1 = 12)。
 * Notice
 * 如果你只用额外空间复杂度O(n)的条件下完成可以获得加分，其中n是数字三角形的总行数。
 */
public class MinimumTotal {

    public static void main(String[] args) {
        int[][] triangle = {{2},{3,2},{6,5,7},{4,4,8,1}};
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(int[][] triangle) {
        if(triangle.length == 1) {
            return triangle[0][0];
        }

        int minNum = Integer.MAX_VALUE;
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.min(triangle[i-1][j], triangle[i-1][j-1]);
                }
                if(i == triangle.length - 1) {
                    minNum = Math.min(triangle[i][j], minNum);
                }
            }
        }

        return minNum;
    }
}
