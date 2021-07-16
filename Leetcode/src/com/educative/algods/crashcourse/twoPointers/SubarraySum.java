package com.educative.algods.crashcourse.twoPointers;

import java.util.HashMap;
/*
* Given an array of integers and a target sum find out whether the array contains a subarray having target sum.
* Solution - This is a classic Prefix sum problem
* */
public class SubarraySum {
    private static int[] findTargetSum(int[] input, int target){
        if(input == null || input.length == 0) return new int[]{-1, -1};
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int currentSum = 0, complement = -1;
        for(int i=0;i<input.length;i++){
            currentSum = currentSum + input[i];
            complement = currentSum - target;
            if(!prefixSum.containsKey(complement)){
                prefixSum.put(currentSum, i);
            }else{
                return new int[]{prefixSum.get(complement)+1, i};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        int[] input = new int[]{1, -20, -3, 30, 5, 7};
        int target = 7;
        int[] targetSubarray = findTargetSum(input, target);
        System.out.println("Target subarray => ["+targetSubarray[0]+", "+targetSubarray[1]+"]");
    }
}
