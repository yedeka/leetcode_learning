package com.educative.algods.crashcourse.dfs;

/*
* Write code to serialize and deserialize a binary tree.
* Sample tree
*       1
*      / \
*     2   6
*    /
*   3
* */
public class BinaryTreeSerializeDeserialize {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    private static String treeString = "";
    private static void serializeTree(Node root){
        if(root == null) treeString+= "X";
        else{
            treeString+= root.val;
            serializeTree(root.left);
            serializeTree(root.right);
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(6);
        Node fourth = new Node(3);

        root.left = second;
        root.right = third;
        second.left = fourth;

        serializeTree(root);
        System.out.println("Serialized Tree => "+treeString);
    }
}
