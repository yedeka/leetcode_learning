package com.leetcode.preps.linkedlist.twopointers;

import java.util.Objects;

// Key point here is start both the pointers at head otherwise you will always have hare faster than tortoise.
public class TwoPointersFindIntersection {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }


    public static ListNode findLoopNode(ListNode head){

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;


        //Find whether loop exists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow != fast) return null;
        // We have come out of while loop meaning there is a loop
        ListNode first = head;
        while(slow != first){
            slow = slow.next;
            first = first.next;
        }
        return first;
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
        /*first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;*/

        /*ListNode loopNode = detectCycle(head);
        System.out.println("Loop Node is => "+loopNode.val);*/

        ListNode loopNode = findLoopNode(head);
        System.out.println("Loop Node is => "+loopNode.val);

    }
}
