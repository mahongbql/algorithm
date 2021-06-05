package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-06-05 13:40
 * @Description: 奇怪的打字机
 *
 * aaa 需要打印 1 次
 * abb 需要打印 2 次
 * abc 需要打印 3 次
 *
 * 就是说相同字母的会打印一次，遇到不同的字母可以连续打印
 *
 * 思路：使用动态规划，用二维数组表示从下标多少到多少需要打印的步数
 *
 */
public class StrangePrinter_664 {

    public static void main(String[] args) {
        String s = "asssf";
        int n = s.length();
        int[][] f = new int[n][n];

        for(int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j-1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k+1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }

        System.out.println(f[0][n-1]);
    }
}
