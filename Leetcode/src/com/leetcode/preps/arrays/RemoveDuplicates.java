package com.leetcode.preps.arrays;

public class RemoveDuplicates {
    private static int removeDuplicates(int[] nums){
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args){
        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(input);
        input = new int[]{0,0,1,1,1,2,2,3,3,4,5,6};
        removeDuplicates(input);
    }
}
