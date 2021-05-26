package com.leetcode.preps.linkedlist.conclusion;

public class RandomPointerListCopy {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node deepCopy(Node head){
        if(head == null) return null;
        Node current = head;
        //Run a loop to interleave the new nodes into the existing list
        while(null != current){
            Node newNode = new Node(current.val);
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
            current = newNode.next;
        }
        //Run another loop to set the random pointers correctly for the new list
        current = head;
        //NULL check is added on random pointer to handle the condition of last node in the list with random pointing to zero
        while(current != null){
            // Set the random pointer of new list to the random pointer of old node
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        // Run the last while loop to set everything back in place.
        current = head;
        Node newHead = head.next;
        Node returnHead = head.next;
        while(current != null){
            current.next = current.next.next;
            newHead.next = (newHead.next != null) ? newHead.next.next : null;
            current = current.next;
            newHead = newHead.next;
        }
        return returnHead;
    }

    public static void main(String[] args){
        Node head = new Node(7);
        Node first = new Node(13);
        Node second = new Node(11);
        Node third = new Node(10);
        Node fourth = new Node(1);

        head.next = first;
        first.next = second;
        first.random = head;

        second.next = third;
        third.next = fourth;
        third.random = second;

        Node newHead = deepCopy(head);
        System.out.println("New Head value => "+newHead.val);
    }
}
