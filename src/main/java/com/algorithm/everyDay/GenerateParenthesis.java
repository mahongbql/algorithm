package com.algorithm.everyDay;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        fillParenthesis(n, list, 0, 0, new StringBuffer());
        return list;
    }

    private static void fillParenthesis(int n, List<String> list, int open, int close, StringBuffer sb) {
        if(sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            fillParenthesis(n, list, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(")");
            fillParenthesis(n, list, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
