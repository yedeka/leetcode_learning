package com.leetcode.preps.julychallenge;

import java.util.ArrayList;

public class RemoveLeaves {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    private static ArrayList<ArrayList<Integer>>  solution;
    private static int getHeight(Node root){
        if(root == null) return -1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int nodeHeight = Math.max(leftHeight, rightHeight);
        if(solution.size() == nodeHeight)  solution.add(new ArrayList<Integer>());

        solution.get(nodeHeight).add(root.val);
        return nodeHeight;
    }

    private static ArrayList<ArrayList<Integer>> removeLeaves(Node root){
        solution = new ArrayList<>();
        getHeight(root);
        return solution;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        root.left = second;
        root.right = third;

        second.left = fourth;
        second.right = fifth;
        removeLeaves(root);
    }
}
