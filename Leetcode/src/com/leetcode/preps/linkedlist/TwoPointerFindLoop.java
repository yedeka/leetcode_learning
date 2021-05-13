package com.leetcode.preps.linkedlist;

import java.util.List;

/*
* Find loop in given linked list.
* Use a two pointer appraoch with one fast and one slow pointer to solve this problem.
* The linked list has a loop if the fast pointer meets slow pointer without reaching till the end.
* */
public class TwoPointerFindLoop {
    public static class ListNode {
        public int value;
        ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }

    public static boolean findLoop(ListNode head){
        Boolean isLoopPresent = false;
        ListNode slowPointer = head.next;
        ListNode fastPointer = head.next.next;
        while(fastPointer.value != slowPointer.value){
            if(fastPointer.next != null){
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }else{
                return isLoopPresent;
            }
            if(fastPointer == null) return isLoopPresent;
        }
        isLoopPresent = true;
        return isLoopPresent;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = third;

        System.out.println("The given list has loop => "+findLoop(head));


    }
}
