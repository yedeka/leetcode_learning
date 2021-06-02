package com.leetcode.preps.arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;
        for(int p = m+n-1; p>=0;p++){
            if(p2 < 0) break;
            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums2[p1--];
            }else{
                nums1[p] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args){
        /*int[] nums1= new int[]{1,2,3,0,0,0};
        int m= 3;
        int[] nums2= new int[]{2,5,6};
        int n= 3; */
        int[] nums1= new int[]{4,0,0,0,0,0};
        int m = 1;
        int[] nums2= new int[]{1,2,3,5,6};
        int n = 5;
        merge(nums1, m,nums2, n);
    }
}
