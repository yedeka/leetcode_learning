package com.leetcode.preps.linkedlist.classic;

public class EvenOddList {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode evenOddList(ListNode head){
        ListNode prevNode = head;
        ListNode currentNode = head.next;
        ListNode firstEvenNode = currentNode.next;
        ListNode p = null;
        int cnt = 1;
        while(currentNode.next != null){
            p = currentNode.next;
            currentNode.next = currentNode.next.next;
            prevNode =currentNode;
            currentNode = p;
            cnt ++;
        }
        if(cnt %2 == 0){
            prevNode.next = firstEvenNode;
        }else{
            currentNode.next = firstEvenNode;
        }
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
