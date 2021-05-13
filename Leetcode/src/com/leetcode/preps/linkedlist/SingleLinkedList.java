package com.leetcode.preps.linkedlist;

/*
* Use the idea of sentinel node i.e. head node. Head node will always be present with value -1.
* */
class SingleLinkedList {
    linkedListNode head;
    int listSize;

    class linkedListNode{
        int value;
        linkedListNode next;

        public linkedListNode(int val){
            this.value = val;
        }
    }


    public String toString(){
        String strReturn = "HEAD";
        linkedListNode currentNode = head;
        for(int i=0;i<listSize;i++){
            strReturn = strReturn + " => "+ currentNode.next.value;
            currentNode = currentNode.next;
        }
        return strReturn;
    }

    /** Initialize your data structure here. */
    public SingleLinkedList() {
        head = new linkedListNode(-1);
        listSize = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > listSize - 1){
            return -1;
        }else{
            linkedListNode current = head;
            for(int i=0;i<index;i++) current = current.next;
            return current.next.value;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(listSize, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // Maxsize validation
        if (index > listSize) return ;
        //For negative index set the index to 0
        if (index < 0) index = 0;
        //Increment the previous node to point to the node at which we need to insert
        linkedListNode pred = head;
        for(int i=0;i<index;i++) pred = pred.next;
        linkedListNode nodeToAdd = new linkedListNode(val);
        //Insert actual node
        nodeToAdd.next = pred.next;
        pred.next = nodeToAdd;
        listSize ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index > listSize - 1) return;
        linkedListNode pred = head;
        for(int i=0;i<index;i++) pred = pred.next;
        pred.next = pred.next.next;
        listSize --;
    }

    public static void main(String[] args){
        SingleLinkedList ll = new SingleLinkedList();
        System.out.println(ll.get(1));
        ll.addAtHead(1);
        ll.addAtTail(2);
        ll.addAtIndex(0,3);
        ll.deleteAtIndex(1);
        System.out.println(ll);
        //System.out.println((5 - 5/2) + 5/2);
    }
}

