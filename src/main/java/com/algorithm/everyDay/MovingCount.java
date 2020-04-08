package com.algorithm.everyDay;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MovingCount {

    static int count;
    static int _m;
    static int _n;
    static int _k;
    static boolean[][] axis;

    public static void main(String[] args) {
        System.out.println(movingCount(3,1,0));
    }

    public static int movingCount(int m, int n, int k) {
        _m = m;
        _n = n;
        _k = k;
        axis = new boolean[m][n];
        return running(0,0);
    }

    private static int running(int x, int y) {
        if(x >= _m || y >= _n || x < 0 || y < 0) return 0;
        int sum = x%10 + x/10 + y%10 + y/10;
        if(sum <= _k && !axis[x][y]) {
            axis[x][y] = true;
            count++;

            running(x+1, y);
            running(x, y+1);
        }

        return count;
    }
}
