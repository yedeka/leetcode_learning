package com.leetcode.preps.binarySearch;

import java.util.ArrayList;

public class FindKClosestElements {
    private static ArrayList<Integer> findKClosest(int[] nums, int k, int x) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (nums == null || nums.length < k) return resultList;
        if (nums.length == k) {
            for (int i = 0; i < nums.length; i++) resultList.add(nums[i]);
            return resultList;
        }
        int left=0, right = nums.length - 1, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < x) left = mid + 1;
            else if(nums[mid] > x) right = mid - 1;
            else break;
        }
        //Find out the
        return resultList;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5};
        int k = 4, x= 10;
        findKClosest(input, k, x);
    }
}
