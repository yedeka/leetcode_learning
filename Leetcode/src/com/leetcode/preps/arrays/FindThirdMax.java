package com.leetcode.preps.arrays;

/*
* Given an array of non zero numbers find the third maximum of the elements.
* If arrau contains less than three elements then return the maximum.
* */
public class FindThirdMax {
    private  static int findThirdMax(int[] nums, int k){
        // initialize maxs array to hold required number of maximums
        // array will contain elements with maxs[i] > maxs[i+1] ,i.e., largest to smallest
        Integer[] maxs = new Integer[k];
        // note: at starting every element will be null because we use Integer object instead of int primitive
        // and we will using this null check with logic below
        // iterate over each number and try to add it in array of maxs
        for (int n : nums) {
            insert(maxs, n);
        }
        // check if we have required number of maxs
        // if we have, return kth largest, which is at the end
        // else return the largest, which is at the beginning
        return maxs[k-1] != null ? maxs[k-1] : maxs[0];
    }

    private static void insert(Integer[] array, int num) {
        int len = array.length;
        int pos = 0;
        // find location to insert
        while(pos < len) {
            Integer max = array[pos];
            if (max == null || max < num) break; //found an empty location or value is lesser
            if (max == num) pos = len; // handle duplicate entry, do not insert; see if() statement below
            pos++;
        }

        // only insert num if we have valid pos
        if (pos < len) {
            // shift array show that there is room for num
            rightShift(array,pos);
            // write num to pos
            array[pos] = num;
        }
    }

    // this method will shift all the elements to the right from fromIndex
    // time complexity of which is O(k) and is added to insertion sort complexity above
    private static void rightShift(Integer[] array, int fromIndex) {
        for (int i = array.length - 1; i > fromIndex; i--) {
            array[i] = array[i - 1];
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{12, 3, 8, 9, 12, 12, 7, 8, 12, 4, 3, 8, 1};
        findThirdMax(input, 3);
    }
}
