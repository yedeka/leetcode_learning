package com.educative.algods.crashcourse.binarysearch;

public class FirstElementGreaterThanTarget {
    private static int findFirstGreater(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid, currentGreater = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] < target) left = mid + 1;
            else{
                currentGreater = mid;
                right = mid - 1;
            }
        }
        return currentGreater;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1, 3, 3, 5, 8, 8, 10};
        int target = 2;
        System.out.println("First element index greater than or equal to "+target+" => "+findFirstGreater(nums, target));
        target = 20;
        System.out.println("First element index greater than or equal to "+target+" => "+findFirstGreater(nums, target));
    }
}
