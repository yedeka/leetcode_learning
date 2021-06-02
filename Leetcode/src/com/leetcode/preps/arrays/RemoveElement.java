package com.leetcode.preps.arrays;

public class RemoveElement {
    private static int removeElement(int[] nums, int val){
        int i=0;
        for(int j=0; j<nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    private static int removeRare(int[] nums, int val){
        int i=0, n = nums.length;
        while(i< n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n --;
            }else{
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,2,2,3};
        int val = 3;
        int newsize = removeElement(arr, val);
        System.out.println("Size of new array => "+newsize);
        arr = new int[]{4,5,3,2,1,0};
        val = 4;
        newsize = removeRare(arr, val);
        System.out.println("Size of new array => "+newsize);
    }
}
