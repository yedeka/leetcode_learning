package com.leetcode.preps.binarySearch;

/*
* Given an array of sorted numbers and an integer find out the starting and ending indices of the target in the given array
* */
public class FindFirstAndLastPositions {
    private static int[] findFirstLastTarget(int[] nums, int target){
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int startPosition = findPosition(nums, target, true);
        if(startPosition == -1) return new int[]{-1, -1};
        int endPosition = findPosition(nums, target, false);
        return new int[]{startPosition, endPosition};
    }

    private static int findPosition(int[] nums, int target, boolean isFirst){
        int left = 0, right = nums.length - 1, mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){// We found the target number occurance
                if(isFirst){// Find out the beginning index of the number
                    if(mid == left || nums[mid - 1] != target) return mid;
                    else right = mid - 1;
                }else{
                    if(mid == right || nums[mid+1] != target) return mid;
                    else left = mid + 1;
                }
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] position = findFirstLastTarget(input, target);
        System.out.println("Starting Position => "+position[0]+", Ending Position => "+position[1]);
    }
}
