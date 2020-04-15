package com.algorithm.everyDay;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        MyListNode l1 = new MyListNode(7);
        MyListNode l3 = new MyListNode(2);
        MyListNode l5 = new MyListNode(4);
        MyListNode l7 = new MyListNode(3);

        l1.next = l3;
        l3.next = l5;
        l5.next = l7;

        MyListNode l2 = new MyListNode(5);
        MyListNode l4 = new MyListNode(6);
        MyListNode l6 = new MyListNode(4);

        l2.next = l4;
        l4.next = l6;

        MyListNode nodeList = addTwoNumbers(l1, l2);
        while(nodeList != null) {
            System.out.print(nodeList.val  + " -> ");
            nodeList = nodeList.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static MyListNode addTwoNumbers(MyListNode l1, MyListNode l2) {
        MyListNode newList = new MyListNode(-1);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> newS = new Stack<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int up = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + up;
            up = sum >= 10 ? 1 : 0;
            newS.push(sum%10);
        }

        while(!s1.isEmpty()) {
            int sum = s1.pop() + up;
            up = sum >= 10 ? 1 : 0;
            newS.push(sum%10);
        }
        while(!s2.isEmpty()) {
            int sum = s2.pop() + up;
            up = sum >= 10 ? 1 : 0;
            newS.push(sum%10);
        }

        if(up == 1)
            newS.push(1);

        MyListNode head = newList;
        while(!newS.isEmpty()) {
            MyListNode newNode = new MyListNode(newS.pop());
            newList.next = newNode;
            newList = newList.next;
        }

        return head.next;
    }
}

class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int x) { val = x; }
}