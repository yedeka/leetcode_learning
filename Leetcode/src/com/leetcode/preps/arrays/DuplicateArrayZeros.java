package com.leetcode.preps.arrays;

public class DuplicateArrayZeros {
    private static void duplicateZeros(int[] arr){
        int possibleDups = 0;
        int length_ = arr.length - 1;

        for (int left = 0; left <= length_ - possibleDups; left++) {
            if (left == length_ - possibleDups) {
                arr[length_] = arr[left];
                length_ --;
                break;
            }
            if (arr[left] == 0) {
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
    public static void main(String[] args){
        int [] input = new int[] {8,4,5,0,0,0,0,7};
        //int [] input = new int[] {1,0,2,3,0,4,5,0};
        duplicateZeros(input);
    }
}
