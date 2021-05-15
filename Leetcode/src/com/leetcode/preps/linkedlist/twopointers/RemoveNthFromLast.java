package com.leetcode.preps.linkedlist.twopointers;

public class RemoveNthFromLast {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode getNthFromLast(ListNode head, int n){
        ListNode dummy = new ListNode(-2);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        //Advance first pointer so that when it reaches to end then second pointer is at the node to be deleted
        for(int i=0;i<=n;i++){
            firstPtr = firstPtr.next;
        }
        while(firstPtr != null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        secondPtr.next = secondPtr.next.next;
        return dummy.next;
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

        ListNode headPostRemoval = getNthFromLast(head, 2);

    }
}
