package com.leetcode.preps.arrays;

public class SortArrayByParity {
    private static int[] paritySort(int[] input){
        for(int evenPosition = 0, cnt = 0; cnt<input.length;cnt++){
            //Found an odd element
            if(input[cnt] % 2 == 0){
                int temp = input[cnt];
                input[cnt] = input[evenPosition];
                input[evenPosition] = temp;
                evenPosition++;
            }
        }
        return input;
    }
    public static void main(String[] args){
        int[] input = new int[]{3,5,7,2,4};
        int[] paritySortedArray = paritySort(input);
    }
}
