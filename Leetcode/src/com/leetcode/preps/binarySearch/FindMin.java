package com.leetcode.preps.binarySearch;

/*
* Problem Statement - You are given a rotated sorted array and you need to find the minimum element in the array
* */
public class FindMin {
    private static int findMin(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid;
        // Check if array is rotated or not, if Not return first element as smallest element
        if(nums[right] > nums[left]) return nums[left];
        while(right >= left){
            mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            else if(nums[mid - 1] > nums[mid]) return nums[mid];
            if(nums[mid] > nums[0]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] input = new int[]{5,4,1,2,3};
        int smallestNumber = findMin(input);
        System.out.println("Smallest Number => "+smallestNumber);
    }
}
