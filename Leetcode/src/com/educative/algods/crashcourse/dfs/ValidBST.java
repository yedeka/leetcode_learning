package com.educative.algods.crashcourse.dfs;

/* problem statment = Given a binary tree find out whether the given binary tree is a binary saerch tree or not.
*  Solution - For each node at each level we need to determine if it's in a range or not. If it is then it's a valid node and we return true else false.
*  i.e. for left node it should be Integer.MIN_VALUE <= node.val <= parent.val and for right node it should be parent.val <= node.val <= Integer.MAX_VALUE
* */
public class ValidBST {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static boolean isValidBST(Node root, int iMin, int iMAX){
        if(root == null) return true;
        if(!(iMin <= root.val && root.val<= iMAX)) return false;
        return isValidBST(root.left, iMin, root.val) && isValidBST(root.right,root.val,iMAX);
    }

    public static void main(String[] args){
        Node root = new Node(6);
        Node second = new Node(4);
        Node third = new Node(8);
        Node fourth = new Node(8);
        Node fifth = new Node(5);

        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;

        System.out.println("Given binary tree is a Binary Search Tree => "+isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
