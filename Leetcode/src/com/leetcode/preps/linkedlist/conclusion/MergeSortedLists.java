package com.leetcode.preps.linkedlist.conclusion;

public class MergeSortedLists {
    private static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode mergeSortedList(ListNode head1, ListNode head2){
        if(null == head1) return head2;
        if(null == head2) return head1;

        ListNode aux = new ListNode(-1);
        ListNode prev = aux,next;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                prev.next = head1;
                head1 = head1.next;
            }else{
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }
        prev.next = head1 == null ? head2 : head1;
        return aux.next;
    }

    public static void main(String[] args){
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(4);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        ListNode firstSecondNode = new ListNode(1);
        ListNode secondSecondNode = new ListNode(5);
        ListNode thirdSecondNode = new ListNode(6);
        firstSecondNode.next = secondSecondNode;
        secondSecondNode.next = thirdSecondNode;

        mergeSortedList(firstNode, firstSecondNode);






    }
}
