package com.leetcode.preps.arrays;

/*
* Problem Statement - Given an array that contains only 1s and 0s find out the maximum subsequence such that only one zero can be flipped to have consecutive zeros.
* Essentially what this means is we need to find a window of max length that contains a single 0.
* The brute force approach will be to check for every possible subsequence and count maximum length of ones such that we have only one zero.
* Time Complexity - Brute Force appraoch O(n^2)
* Sliding window approach - Start from the zeroth index and expand the window until you find 2 zeros then start to reduce the window until you get a single zero. count the length
* */
public class MaxConsecOnes {
    private static int findMaxConsecutiveOnes(int[] nums){
        int windowStart =0, windowEnd = 0, zeroCount=0, longestOnes = 0;
        while(windowEnd < nums.length){
            //If element at windowend index is 0 increment the zero count
            if(nums[windowEnd] == 0){
                zeroCount++;
            }
            // WE got more than one zeros in current window hence it is an invalid window.
            while(zeroCount == 2){
                if(nums[windowStart] == 0){
                    zeroCount --;
                }
                windowStart++;
            }
            longestOnes = Math.max(longestOnes, windowEnd-windowStart + 1);
            windowEnd++;
        }
        return longestOnes;
    }

    public static void main(String[] args){
        int [] input = new int[]{1,0,1,1,0};
        int longestOnesWithSingleFlip = findMaxConsecutiveOnes(input);
        System.out.println(longestOnesWithSingleFlip);
    }
}
