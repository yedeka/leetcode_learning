package com.leetcode.preps.arrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveVal(int[] input, int value){
        int windowEnd = 0, windowStart = 0, maxOccurance = 0;
        while(windowEnd < input.length){
            if(input[windowEnd] == value){
                windowEnd ++;
            }else{
                maxOccurance = Math.max(maxOccurance, windowEnd - windowStart);
                windowEnd ++;
                windowStart = windowEnd;
            }
        }
        //if(windowEnd == 1){
            maxOccurance = Math.max(windowEnd - windowStart, maxOccurance);
        //}
        return maxOccurance;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,1,0,1,1,0,1,0};
        int val = 1;
        int maxConsecutiveNumber = findMaxConsecutiveVal(input, val);
        System.out.println("Max count of consecutive "+val+"'s in gven array is "+maxConsecutiveNumber);
    }
}
