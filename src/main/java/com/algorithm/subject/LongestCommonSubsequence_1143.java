package com.algorithm.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-08 00:16
 * @Description: 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 */
public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        String text1 = "abcba";
        String text2 = "abcbcba";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] commonSubsequence = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            char ch1 = text1.charAt(i-1);
            for(int j = 1; j <= n; j++) {
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2) {
                    commonSubsequence[i][j] = commonSubsequence[i-1][j-1] + 1;
                } else {
                    commonSubsequence[i][j] = Math.max(commonSubsequence[i-1][j], commonSubsequence[i][j-1]);
                }
            }
        }

        return commonSubsequence[m][n];
    }
}