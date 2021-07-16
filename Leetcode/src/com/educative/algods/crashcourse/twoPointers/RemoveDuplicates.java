package com.educative.algods.crashcourse.twoPointers;

/*
* Given a sorted array of intergers remove duplicates from the array and return an array of unique elements
* Solution - We will use two pointer approach for solution.
* We will initialize the slow pointer to 0 and iterate through the array using fast pointer.
* When fast pointer and slow pointer do not match we will increment slow pointer and replace the slow pointer contents with fast pointer.
* We will thus get the unique elements from index o to slow pointer.
* */
public class RemoveDuplicates {
    private static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        int slow = 0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,1,2,2,2};
        int uniqueIndex = removeDuplicates(nums);
        System.out.print("[");
        String strNums = "";
        for(int i=0;i<=uniqueIndex;i++){
            strNums = strNums + nums[i] + ",";
        }
        System.out.println(strNums.substring(0,strNums.length()-1)+"]");
    }
}
