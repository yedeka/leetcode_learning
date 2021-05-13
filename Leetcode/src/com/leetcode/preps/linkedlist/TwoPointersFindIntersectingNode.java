package com.leetcode.preps.linkedlist;

public class TwoPointersFindIntersectingNode {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode findCommonNode(ListNode headA, ListNode headB){
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while(ptr1 != ptr2){
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }
        return ptr1;

    }

    public static void main(String[] args){
        ListNode headA = new ListNode(-1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        headA.next= first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode headB = new ListNode(-1);
        ListNode eleventh = new ListNode(11);
        ListNode twelth = new ListNode(12);
        ListNode thirteenth = new ListNode(13);

        headB.next= eleventh;
        eleventh.next = twelth;
        twelth.next = thirteenth;
        thirteenth.next = third;

        ListNode intersectingNode = findCommonNode(headA, headB);

        System.out.println("intersectingNode => "+intersectingNode.val);

    }
}
