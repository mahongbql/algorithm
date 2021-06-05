package com.algorithm.subject;

import com.algorithm.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahongbin
 * @Date: 2021-06-05 14:09
 * @Description: 移除链表元素
 *
 * 删除给定链表中等于给定值 val 的节点，并返回新的头节点
 * 例子：
 * 【1】输入：head = [1,2,6,3,4,5,6], val = 6
 *     输出：[1,2,3,4,5]
 *
 * 【2】输入：head = [], val = 6
 *     输出：[]
 *
 * 【3】输入：head = [4,4,4,4,4], val = 4
 *     输出：[]
 */
public class RemoveLinkEle_203 {

    public static void main(String[] args) {
        ListNode node_7 = new ListNode(4, null);
        ListNode node_6 = new ListNode(4, node_7);
        ListNode node_5 = new ListNode(4, node_6);
        ListNode node_4 = new ListNode(4, node_5);
        ListNode node_3 = new ListNode(4, node_4);
        ListNode node_2 = new ListNode(4, node_3);
        ListNode node_1 = new ListNode(4, node_2);

        ListNode node = removeElements(node_1, 4);

        List<Integer> list = new ArrayList<>();
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list);
    }

    private static ListNode removeElements(ListNode node, int val) {
        //新的头节点
        ListNode newHead = node;

        if(node == null) {
            return newHead;
        }

        //前一个节点
        ListNode preNode = null;

        while(node != null) {
            //头节点是指定数字
            if(preNode == null && node.val == val) {
                newHead = node.next;
                node = node.next;
                continue;
            }
            //非头节点是指定数字
            if(node.val == val) {
                preNode.next = node.next;
                node = node.next;
                continue;
            }
            //正常数字
            preNode = node;
            node = node.next;
        }

        return newHead;
    }

}
