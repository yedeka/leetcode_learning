package com.leetcode.preps.arrays;

public class MoveZerosToEnd {
    /*
    * Space optimal and opeartion sub optimal appraoch
    * */
    private static void moveZeros(int[] nums){
        int zeroPosition = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                nums[zeroPosition++] = nums[j];
            }
        }
        for(int i=zeroPosition; i< nums.length;i++ ){
            nums[i] = 0;
        }
    }

    /*
    * Space optimal and operation optimal approach
    * */

    private static void moveZerosOptimal(int[] input){
        for(int lastZeroFound=0, current =0; current< input.length;current++){
            if(input[current] != 0){
                int temp = input[lastZeroFound];
                input[lastZeroFound] = input[current];
                input[current] = temp;
                lastZeroFound++;
            }
        }
    }



    public static void main(String[] args){
        int[] input = new int[] {1,0,2,0,3};
        // moveZeros(input);
        moveZerosOptimal(input);
    }
}
