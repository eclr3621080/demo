package org.example.warehousemanagersystem.study;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-16
 * @Description:
 * @Version: 1.0
 */


public class 链表是否有环 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4= new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        ListNode slow=listNode1;
        ListNode fast=listNode1;
        while (fast!=null && null!=fast.next) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                System.out.println("是个环");
                return;
            }
        }
        System.out.println("不是个环");
    }
}
