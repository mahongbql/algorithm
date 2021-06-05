package com.algorithm.bean;

/**
 * @Auther: mahongbin
 * @Date: 2021-06-05 14:18
 * @Description: 链表节点
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {}

    public ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}
