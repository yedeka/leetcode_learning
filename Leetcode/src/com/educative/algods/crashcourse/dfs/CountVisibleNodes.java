package com.educative.algods.crashcourse.dfs;

/* Given a tree find all the visible tree nodes in the tree.
*  A visible tree node is a node such that there exists no node between root to that node which is greater than the current node.
*  Output - Count of all the visible nodes.
*  State - A node is a visible node if it is greater than the max node on the path from root to that node. Hence alongwith the root we also need to pass
*  the maximum node value as state.
* */
public class CountVisibleNodes {
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    private static int countVisibleNodes(Node root, int maxValue){
        if(root == null) return 0;
        int iTotal = 0;
        // current node value is greater than path max hence current node is a visible node so increment the visible node count
        if(root.val >= maxValue) iTotal++;
        iTotal += countVisibleNodes(root.left, Math.max(root.val, maxValue));
        iTotal += countVisibleNodes(root.right, Math.max(root.val, maxValue));
        return iTotal;
    }
    public static void main (String[] args){
        Node root = new Node(5);
        Node second = new Node(4);
        Node third = new Node(3);
        Node fourth = new Node(8);
        Node fifth = new Node(6);

        second.left = third;
        second.right = fourth;
        root.left = second;
        root.right = fifth;

        System.out.println("Visible node count for given tree => "+countVisibleNodes(root, Integer.MIN_VALUE));
    }
}
