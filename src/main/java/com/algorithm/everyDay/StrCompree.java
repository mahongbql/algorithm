package com.algorithm.everyDay;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 */
public class StrCompree {

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
    }

    private static String compressString(String S) {
        if(S.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int index = 0;
        int count = 0;
        for(int i = 0; i < chars.length-1; i++)
        {
            count++;
            if(chars[i] != chars[i+1])
            {
                sb.append(chars[i]).append(count);
                count = 0;
                index = i+1;
            }
        }
        sb.append(chars[index]).append(chars.length - index);
        String result = sb.toString();

        return  result.length() < S.length() ? result : S;
    }

    public static String myCompressString(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        int i, j;
        for(i = 0; i < S.length() - 1; i++) {
            j = i + 1;
            if(S.charAt(i) == S.charAt(j)) {
                cnt++;
            } else {
                sb.append(String.valueOf(S.charAt(i)) + cnt);
                cnt = 1;
            }
        }
        sb.append(String.valueOf(S.charAt(i)) + cnt);

        return sb.length() >= S.length() ? S : sb.toString();
    }
}
