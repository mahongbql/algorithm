package com.algorithm.demo.leetCode;

/**
 * @author mahongbin
 * @date 2019/10/29 14:52
 * @Description
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
 * 示例：
 * 给定 `"abcabcbb"` ，没有重复字符的最长子串是 `"abc"` ，那么长度就是3。
 * 给定 `"bbbbb"` ，最长的子串就是 `"b"` ，长度是1。
 * 给定 `"pwwkew"` ，最长子串是 `"wke"` ，长度是3。请注意答案必须是一个 子串 ， `"pwke"` 是 _子序列_ 而不是子串。
 */
public class NoRepeatWords {

    public static void main(String[] args) {
        String input = "pwwkew";
        dealStr(input);
    }

    private static void dealStr(String input) {
        StringBuilder maxStr = new StringBuilder();
        int maxNumber = 0;
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            StringBuilder temp = new StringBuilder();
            temp.append(charArray[i]);
            for (int j = i+1; j < charArray.length; j++) {
                //前一个等于后一个
                if(charArray[i] == charArray[j]) {
                    int number = temp.toString().length();
                    if(number > maxNumber) {
                        maxNumber = number;
                        maxStr = temp;
                    }
                    break;
                }
                //不相等
                else {
                    temp.append(charArray[j]);
                }
            }

        }
        System.out.println("最长子串: " + maxStr.toString() + ", 长度是：" + maxNumber);
    }
}
