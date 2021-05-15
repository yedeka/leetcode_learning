package com.leetcode.preps.linkedlist.classic;

public class ReverseLinkedList {
     public static class ListNode{
         int val;
         ListNode next;

         public ListNode(int val){
             this.val = val;
         }
     }

     public static ListNode reverseList(ListNode head){
         if (head == null) {
             return head;
         }
         ListNode currentHead = head;
         while (head.next != null) {
             ListNode p = head.next;
             head.next = p.next;
             p.next = currentHead;
             currentHead = p;
         }
         return currentHead;
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

         reverseList(head);

     }
}
