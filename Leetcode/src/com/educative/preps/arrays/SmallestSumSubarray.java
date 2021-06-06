package com.educative.preps.arrays;

/*
* Problem Statement - Given an array of positive number and a positive number 'S' find the length of smallest contiguous subarray whose sum is greater than or equal to 'S'.
* An interesting observation here is the terminal condition is checked based on a while loop whereas when the situation is in terms of number os elements of the
* array we usually use an if condition to increment windowStart.
* */
public class SmallestSumSubarray {
    private static int smallestSumSubarray(int[] nums, int k){
        if(nums == null || nums.length == 0) return 0;
        int currentSum = 0, windowStart = 0, windowEnd = 0, length=Integer.MAX_VALUE;
        while(windowEnd < nums.length){
            currentSum = currentSum + nums[windowEnd];
            while(currentSum >=k){
                if(windowEnd - windowStart + 1 < length) length = windowEnd - windowStart + 1;
                currentSum = currentSum - nums[windowStart];
                windowStart ++;
            }
            windowEnd++;
        }
        return length;
    }
    public static void main(String[] args){
        int[] input = new int[]{2,1,5,2,3,2};
        int k = 7;
        int maxSumLength = smallestSumSubarray(input, k);
        System.out.println("MAX Sum Length => "+maxSumLength);
    }
}
