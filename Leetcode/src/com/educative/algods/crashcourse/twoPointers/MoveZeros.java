package com.educative.algods.crashcourse.twoPointers;

/*
* Given an array of number move all the zeros to the end of the array without changing the order of the numbers.
* We use two pointer technique to solve this problem.
* Maintain two pointers slow and fast with for loop running over fast.
* When fast is non zero we replace slow by fast and increment the slow pointer.
* The idea behind this is slow pointer maintains the position of zero element in the array every time and hence replaced by the fast pointer.
* */
public class MoveZeros {
    private static void moveZeros(int[] nums){
        int slow = 0, slowNum;
        if(nums != null || nums.length != 0){
            for(int fast=0;fast<nums.length;fast++){
                if(nums[fast] != 0 ){
                    slowNum = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = slowNum;
                    slow++;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,0,2,0,0,0,7};
        moveZeros(nums);
        nums = new int[]{1};
        moveZeros(nums);
        nums = new int[]{0,0,0,0,1};
        moveZeros(nums);
    }
}
