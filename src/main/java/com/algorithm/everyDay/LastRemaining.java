package com.algorithm.everyDay;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(lastRemainingMain(5, 3));
    }

    private static int lastRemainingMain(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i)
            f = (m + f) % i;
        return f;
    }

    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(i);
        }

        return circle(list, -1, m);
    }

    private static int circle(List<Integer> list, int cur, int m) {
        if(list.size() == 1) {
            return list.get(0);
        }

        int removeIndex = (cur + m) % list.size();
        list.remove(removeIndex);
        int curIndex = (removeIndex - 1) % list.size();

        return circle(list, curIndex, m);
    }
}
