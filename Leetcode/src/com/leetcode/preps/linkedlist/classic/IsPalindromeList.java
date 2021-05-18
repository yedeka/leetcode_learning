package com.leetcode.preps.linkedlist.classic;

public class IsPalindromeList {
    private static class ListNode{
        int val ;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode returnMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static boolean checkPalindrome(ListNode head, ListNode reverseHead, ListNode mid){
        boolean result = true;
        while(head != mid.next){
            if(head.val != reverseHead.val){
                result = false;
                break;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return result;
    }

    private static boolean isPalindrome(ListNode head){
        boolean isPalindrome = false;
        if(head != null){
            // Find mid of the list
            ListNode midNode = returnMid(head);
            // Reverse second half of the list
            ListNode reversedHead = reverseList(midNode.next);
            //Edge case for handling a single node in the list
            if(reversedHead == null) return true;
            // Check for palindrom
            isPalindrome = checkPalindrome(head.next, reversedHead, midNode);
            //Reverse the second half of the list
            ListNode straightHead = reverseList(reversedHead);
            //Reattach the newly straightened list
            midNode.next = straightHead;
            return isPalindrome;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(1);

        head.next = first;
        /*first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;*/
        second.next = fifth;
        fifth.next = sixth;
        System.out.println("Is the given list palindrom => "+isPalindrome(head));
    }
}
