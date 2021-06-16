package com.leetcode.preps.binarySearch;

public class SimpleBinarySearch {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 ) return -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right){
            mid = left + (right - left) /2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;

    }

    public static void main(String[] args){
        int[] input = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int searchIndex = search(input, target);
        System.out.println("Target INDEX => "+searchIndex);
    }
}
