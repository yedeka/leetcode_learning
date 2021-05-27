package com.leetcode.preps.arrays;

public class FindEvenDigitElements {
    private static int findEvenDigitElements(int [] nums){
        if(null == nums) return 0;
        int count, evenDigitNumber = 0;
        for(int i=0;i<nums.length;i++){
            count = 1;
            while(nums[i]/10 > 0){
                nums[i] = nums[i] / 10;
                count++;
            }
            if(count % 2 == 0){
                ++evenDigitNumber;
            }
        }
        return evenDigitNumber;
    }

    public static void main(String[]args){
        int[] input = new int[]{12,345,2,6,7896};
        int ievenNumberedElements = findEvenDigitElements(input);
        System.out.println("Even numbered elements in input => "+ievenNumberedElements);
    }
}
