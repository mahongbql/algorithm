package com.algorithm.subject;

import java.util.Arrays;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-31 12:24
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        // 1 2 3 4
        // 1 3 2 4
        // 1 3 4 2
        // 1 4 2 3
        // 1 4 3 2

        String str = "123";
        char[] chars = str.toCharArray();

        permutation(chars, 0);
    }


    public static void permutation(char[] chars, int begin) {
        // 如果是最后一个元素了，就输出排列结果
        if (chars.length - 1 == begin) {
            System.out.println(new String(chars) + " ");
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i = begin; i < chars.length; i++) {
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
                // 处理下一个位置
                permutation(chars, begin + 1);


                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
            }
        }
    }
}
