package com.leetcode.preps.binarySearchTree;

import java.awt.*;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class FindClosestBST {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    private static void inOrder(TreeNode root, List<Integer> nums){
        if(root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
    //Time complexity O(N) since each element is traversed once.
    // Space complexity O(N) since we need to store the in order traversal.
    private static int findClosest(TreeNode root, double target){
        List<Integer> nums = new ArrayList<Integer>();
        inOrder(root, nums);
        return Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
    }

    private static int findClosest2(TreeNode root, double target){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        long pred = Long.MIN_VALUE;
        // root != null is needed to ensure that we have not reached at the leaf node and not adding null into the stack.
        //!stack.isEmpty is needed to understand that we still have elements to add.
        // After processing one pass left we check for the right subtree at the same level to see if we find any value.
        while(!stack.isEmpty() || root!= null){
            // Populate stack with left tree
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred <= target && target < root.val) return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;
            pred = root.val;
            root = root.right;
        }
        return (int)pred;
    }

    private static int findClosest3(TreeNode root, double target){
        int val,closest = root.val;
        while(root != null){
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  val < target?root.right:root.left;
        }
        return closest;
    }

    public static void main(String[] args){
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, one, three);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(4, two, five);
        /* int closest = findClosest(root, 3.714286);
        int closest = findClosest2(root, 2.12345);*/
        int closest = findClosest3(root, 2.12345);
        System.out.println("Closest Number => "+closest);
    }
}
