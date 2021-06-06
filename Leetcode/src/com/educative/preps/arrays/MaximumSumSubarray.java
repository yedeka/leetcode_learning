package com.educative.preps.arrays;
import java.util.ArrayList;
import java.util.List;

/*
* Problem Statement - Given an array of positive intergers and a positive number k find the maximum sum of any subarray of size K.
* */
public class MaximumSumSubarray {
    private static int maxSumSubarrray(int[] nums, int k){
        if( nums == null || nums.length < k) return 0;
        int maxSum = 0, windowStart =0, windowEnd = 0, currentSum = 0;
        while(windowEnd < nums.length){
            currentSum = currentSum + nums[windowEnd];
            // k elements reached now we need to shrink the window
            if(windowEnd - windowStart + 1 == k){
                if(currentSum > maxSum) maxSum = currentSum;
                currentSum = currentSum - nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] input = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxSum = maxSumSubarrray(input, k);
        System.out.println("K => "+k+" Max Sum => "+maxSum);
    }
}
