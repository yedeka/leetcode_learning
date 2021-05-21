package com.leetcode.preps.linkedlist.conclusion;

public class SortedCircularListInsert {
    private static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }


    }

    public static Node insertCyclic(Node head, int insertValue){
        if (head == null){
            Node auxHead = new Node(insertValue);
            auxHead.next = auxHead;
            return auxHead;
        }else{
            Node current = head;
            while (true){
                // Normal case of having value in between the list nodes
                if(current.val <= insertValue && insertValue <= current.next.val){
                    Node temp = new Node(insertValue, current.next);
                    break;
                }
                // Case of going beyond the last node and having value
                if(current.val > current.next.val){
                    // Another condition of having insertvalue the gretest value in the list i.e. greater than the maximum value
                    if(insertValue >= current.val && insertValue >= current.next.val){
                        break;
                    }
                    // Another condition of having insertvalue the smallest value in the list i.e. smaller than the minimum value
                    if(insertValue <= current.val && insertValue <= current.next.val){
                        break;
                    }
                }
                current = current.next;
                // A very specific condition of having nodes duplicate as head
                if(current == head){
                    break;
                }
            }
            Node temp = new Node(insertValue);
            Node next = current.next;
            current.next = temp;
            temp.next = next;
            return head;
        }


    }

    public static void main(String[] args){
        Node first = new Node(3);
        Node dummyFirst = new Node(4);
        Node second = new Node(1);
        Node third = new Node(3);

        //first.next = second;
        first.next = dummyFirst;
        dummyFirst.next = second;
        second.next = third;
        third.next = first;

        insertCyclic(first, 2);

    }
}
