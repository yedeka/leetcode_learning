package com.leetcode.preps.linkedlist.classic;

public class EvenOddListLT {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int value){
            this.val = value;
        }
    }

    public static ListNode evenOddList(ListNode head){
        ListNode odd = head.next;
        ListNode evenHead = odd.next, even = odd.next;
        while(even!= null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        evenOddList(head);
    }
}
