package com.leetcode.preps.binarySearch;

public class SearchRotatedSortedArray {
    private static int enhancedBinSearch(int[] nums, int target){
        int result = -1, left = 0, right = nums.length - 1, mid, value;
        while(left <= right){
            mid = left + (right -left) / 2;
            value = nums[mid];
            if(target == value){
                result = mid;
                break;
            }
            else if(value >= nums[left]){//Non-rotated subarray
                if(target >= nums[left] && target < value) right = mid -1;
                else left = mid +1;
            }
            else{// We have encountered a rotated sub array
                if(target <= nums[right] && target > value) left = mid +1;
                else right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] input = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int targetIndex = enhancedBinSearch(input, target);
        System.out.println("Target Index => "+targetIndex);
    }
}
