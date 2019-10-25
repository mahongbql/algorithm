package com.algorithm.demo.leetCode;

/**
 * @author mahongbin
 * @date 2019/10/25 11:25
 * @Description
 *
 * 给定两个 非空 链表来表示两个非负整数。位数按照 逆序 方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入： (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出： 7 -> 0 -> 8
 * 原因： 342 + 465 = 807
 */
public class SumTwoNumber {
    public static void main(String[] args) {
        String input = "(2 -> 4 -> 3) + (5 -> 6 -> 4)";
        dealOut(input);
    }

    public static void dealOut(String input) {
        String[] str = input.split("\\+");
        String[] start = str[0].split(" -> ");
        String[] last = str[1].split(" -> ");
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for(int i = 0; i < start.length; i++) {
            builder1.append(start[i]);
        }

        for(int i = 0; i < last.length; i++) {
            builder2.append(last[i]);
        }

        int sum1 = Integer.parseInt(builder1.toString().replace("(", "").replace(")", "").trim());
        int sum2 = Integer.parseInt(builder2.toString().replace("(", "").replace(")", "").trim());
        int sum = sum1 + sum2;
        char[] charArray = String.valueOf(sum).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = charArray.length - 1; i >= 0; i--) {
            stringBuilder.append(charArray[i]);
            if(i > 0) {
                stringBuilder.append(" -> ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
