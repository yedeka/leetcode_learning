package com.educative.algods.crashcourse.dfs;

/*
* Max Depth of binary tree is the longest path from root to leaf.
* We return max depth as zero for null node i.e. when we reach beyond leaf.
* Then we count the depth of each level as Math.max(maxDepth(node.left), maxDepth(node.right)) + 1
* */
public class MaxDepthBinTree {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static int findMaxDepth(Node root){
        //We have reached till the end and we are below leaf node now return zero
        if(root == null) return 0;
        //Max depth for current subtree is maximum of it's depth between the left and right subtree
        return Math.max(findMaxDepth(root.left), findMaxDepth(root.right)) + 1;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        sixth.right = seventh;
        fifth.left = sixth;
        second.left = fourth;
        second.right = fifth;
        root.left = second;
        root.right = third;

        System.out.println("MAX Depth of the tree is "+findMaxDepth(root));
    }
}
