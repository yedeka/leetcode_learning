package com.educative.algods.crashcourse.dfs;
/* Find whether a node exists in a tree or not*/
public class DFSRecursive {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

    }

    private static Node findTarget(Node root, int target){
        if (root == null) return null;
        if(root.value == target ) return root;
        // return non-null return value from the recursive calls
        Node left = findTarget(root.left, target);
        if (left != null) {
            return left;
        }
        return findTarget(root.right, target);
    }

    public static void main(String[] args){
        Node root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        third.right = fifth;
        second.left = third;
        second.right = fourth;
        root.left = second;
        root.right = sixth;

        int iTarget = 4;
        Node isTarget = findTarget(root, iTarget);
        System.out.println(" Given Btree contains "+iTarget+" => "+(isTarget != null));

        iTarget = 10;
        isTarget = findTarget(root, iTarget);
        System.out.println(" Given Btree contains "+iTarget+" => "+(isTarget != null));
    }
}
