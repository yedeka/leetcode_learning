package com.leetcode.preps.arrays;

/* Remove deuplicates from an array of numebrs such that it has only 2 duplicates of each number.*/
public class RemoveDuplicatesII {
    public static int removeDuplicates(int[] nums) {
    int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public static void main(String[] args){
        int[] input = new int[] {1,1,2,3,3,3,3};
        int DoubleduplicateSize = removeDuplicates(input);
    }

}
