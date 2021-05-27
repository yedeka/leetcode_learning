package com.leetcode.preps.arrays;

public class SortedArraySquares {
    private static int[] findArraySquare(int[] nums){
        int squareLength = nums.length - 1;
        int[] squareArray = new int[squareLength + 1];
        int left = 0, right =  squareLength;
        while(left < right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                squareArray[squareLength] = nums[left] * nums[left];
                left ++;
            }else{
                squareArray[squareLength] = nums[right] * nums[right];
                right --;
            }
            squareLength --;
        }
        return squareArray;
    }
    public static void main(String [] args){
        int[] input = new int[]{-4, -1, 0};
        int [] sortedSquareArray = findArraySquare(input);
    }
}
