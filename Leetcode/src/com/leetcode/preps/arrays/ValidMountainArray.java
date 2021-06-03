package com.leetcode.preps.arrays;

public class ValidMountainArray {
    private static boolean isMountain(int[] arr){
        int i=0, length = arr.length;
        while(i+1 < length && arr[i] < arr[i+1]) i++;
        if(i ==0 || i == length-1) return false;
        while(i+1 < length && arr[i] > arr[i+1]) i++;
        return i == length-1;
    }
    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,4,3,1};
        boolean isMountain = isMountain(input);
        System.out.println("INPUT => "+isMountain);
    }
}
