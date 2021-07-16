package com.educative.algods.crashcourse.twoPointers;


/*
* Given a linked list find the middle of the list.
* Use slow and fast pointers. When fast pointer reaches at the end since it is moving at twice the pace slow pointer gives the middle.
* */
public class MiddleofList {
    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode findMiddle(ListNode head){
        ListNode slow = head, fast=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        ListNode middlenode = findMiddle(head);
        System.out.println("Middle node of the list => "+middlenode.val);

        fifth.next = null;

        middlenode = findMiddle(head);
        System.out.println("Middle node of the list => "+middlenode.val);

        head.next = null;
        middlenode = findMiddle(head);
        System.out.println("Middle node of the list => "+middlenode.val);



    }
}
