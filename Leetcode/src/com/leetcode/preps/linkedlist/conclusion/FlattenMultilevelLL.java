package com.leetcode.preps.linkedlist.conclusion;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class FlattenMultilevelLL {
    private static class Node{
        int val;
        Node next;
        Node previous;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node flattenList(Node head){
        if(head == null) return null;
        Node auxHead = new Node(-1);
        Node prev = auxHead, curr = auxHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while(!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            curr.previous = prev;
            prev = curr;

            if(curr.next != null) stack.push(curr.next);
            if(curr.child != null){
                stack.push(curr.child);
                curr.child = null;
            }
        }

        return auxHead.next;
    }

    public static void main(String[] args){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        Node nineth = new Node(9);

        first.next = second;

        second.previous = first;
        second.next = third;
        second.child = fifth;

        third.next = fourth;
        third.previous = second;

        fourth.previous = third;

        fifth.previous = second;
        fifth.next = sixth;

        sixth.previous = fifth;
        sixth.next = seventh;
        sixth.child = eighth;

        seventh.previous = sixth;

        eighth.previous = sixth;
        eighth.next = nineth;

        nineth.previous = eighth;

        flattenList(first);
        System.out.println("DONE");
    }
}
