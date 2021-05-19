package com.leetcode.preps.linkedlist.conclusion;

public class AddNumbers {
    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2){
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode aux = new ListNode(-1);
        ListNode prevNode = aux, currentNode;
        int prev = 0, value;
        while(l1 != null && l2!= null){
            value = prev + l1.val + l2.val;
            prev = value / 10;
            currentNode = new ListNode(value % 10);
            prevNode.next = currentNode;
            prevNode = currentNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            value = prev + l1.val;
            prev = value / 10;
            currentNode = new ListNode(value % 10);
            prevNode.next = currentNode;
            prevNode = currentNode;
            l1 = l1.next;
        }
        while(l2 != null){
            value = prev + l2.val;
            prev = value / 10;
            currentNode = new ListNode(value % 10);
            prevNode.next = currentNode;
            prevNode = currentNode;
            l2 = l2.next;
        }
        if(prev > 0){
            prevNode.next = new ListNode(prev);
        }
        return aux.next;
    }

    public static void main(String[] args){
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);

        first.next = second;
        second.next = third;

        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        ListNode sixth = new ListNode(4);

        fourth.next = fifth;
        fifth.next = sixth;

        ListNode resultHead = addNumbers(first, fourth);
        System.out.println("DONE");

    }
}
