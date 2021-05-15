package com.leetcode.preps.linkedlist.classic;

import java.util.List;

public class RemoveListNode {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode removeMatchingNode(ListNode head, int val){
        if (null == head)
            return null;
        ListNode dummy = new ListNode(-2);
        dummy.next = head;
        ListNode previous = head;
        ListNode current = null;
        while(previous.next != null){
            current = previous.next;
            if(current.val == val){
                previous.next = current.next;
            }
            previous = current;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        ListNode newHead = removeMatchingNode(head, 2);
        newHead = removeMatchingNode(head, 6);
        newHead = removeMatchingNode(head, 1);

    }
}
