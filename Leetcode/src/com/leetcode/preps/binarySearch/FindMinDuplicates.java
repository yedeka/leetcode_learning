package com.leetcode.preps.binarySearch;

/* Find minimum element from an array of sorted elements that can contain duplicates*/
public class FindMinDuplicates {
    private static int findMinDup(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        if(nums[0] < nums[nums.length - 1]) return nums[0];
        int left = 0,right = nums.length - 1, mid;
        while(left < right){
            mid = left + (right - left)/2;
            if(nums[mid] < nums[right]) right = mid;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = right  -1;// This is very critical condition that needs to be checked for checking the duplicates.
            // Reducing right one by one we give a chance to find the exact correct value without going into infinite loop.
        }
        return nums[left];
    }

    public static void main(String[] args){
        int[] input = new int[]{4,5,6,7,0,1,4};
        int minElement = findMinDup(input);
        System.out.println("Mimimum element in the sorted array of duplicate elements => "+minElement);
    }
}
