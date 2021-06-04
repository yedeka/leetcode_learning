package com.leetcode.preps.arrays;

/*
* Find out maximum count of consecutive ones give a maximum of k number of zeros can be flipped.
* */
public class MaxOneCountIII {
    private static int findConsecOnes(int[] nums, int k){
        if(null == nums || nums.length == 0) return 0;
        int windowStart = 0, windowEnd = 0, zeroCnt = 0, maxOneCnt = 0;
        while(windowEnd < nums.length){
            if(nums[windowEnd] == 0) zeroCnt++;
            while(zeroCnt == k+1){
                if (nums[windowStart] ==0) zeroCnt--;
                windowStart++;
            }
            maxOneCnt = Math.max(maxOneCnt, windowEnd - windowStart + 1);
            windowEnd ++;
        }
        return maxOneCnt;
    }
    public static void main(String[] args){
        int[] input = new int[]{1,1,0,1,1,1,1,0,1,0,1};
        int k = 2;
        int maxOneCount = findConsecOnes(input, k);
        System.out.println("maxOneCount => "+maxOneCount);
    }
}
