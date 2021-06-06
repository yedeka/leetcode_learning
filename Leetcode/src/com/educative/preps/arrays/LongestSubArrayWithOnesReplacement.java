package com.educative.preps.arrays;
/*
* Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
* find the length of the longest contiguous subarray having all 1s.
* */
public class LongestSubArrayWithOnesReplacement {
    private static int findLongestOnesSubArray(int[] arr, int k){
        int windowStart = 0, zeroCnt = 0, maxLength = 0;
        for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){
            if(arr[windowEnd] == 0) zeroCnt++;
            while(zeroCnt > k){
                if(arr[windowStart] == 0) zeroCnt--;
                windowStart++;
            }
            // Always remember to use the code to find out any max length needs to be outside the condition for checking the loop.
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        int[] input = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        int max1sLength = findLongestOnesSubArray(input, k);
        System.out.println("Longest Contiguous subarray with repalcement => "+max1sLength);
    }
}
