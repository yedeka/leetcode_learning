package com.leetcode.preps.linkedlist.classic;

public class RotateList {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode rotateList(ListNode head, int k){
        if (head == null) return null;
        // First make the list circular list as well as count the list nodes
        ListNode current = head;
        int iNodeCnt = 1;
        while(current.next != null) {
            current = current.next;
            iNodeCnt ++;
        }
        current.next = head;
        // Now find out where the tail of the list will be to make corresponding nexgt pointer as null
        current = head;
        int cnt = 0;
        while(cnt < iNodeCnt - k % iNodeCnt - 1){
            current = current.next;
            cnt++;
        }
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(5);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        ListNode rotatedHead = rotateList(head, 2);

    }
}
