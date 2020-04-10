package com.algorithm.interview;


/**
 * 反转一个链表
 */
public class ReverseNode {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

//        ListNode head = reverse_1(n1);

        ListNode head = reverse_2(n1);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 方法2：递归实现，每次传递下一个节点，最后返回的 newNode 是新的头节点，也就是老链表的头节点
     * @param node
     * @return
     */
    private static ListNode reverse_2(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode newNode = reverse_2(node.next);
        node.next.next = node;
        node.next = null;

        return newNode;
    }

    /**
     * 方法1：循环，两个指针，前一个节点与后一个节点
     * @return
     */
    private static ListNode reverse_1(ListNode node) {
        ListNode pre = null;
        ListNode next;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
