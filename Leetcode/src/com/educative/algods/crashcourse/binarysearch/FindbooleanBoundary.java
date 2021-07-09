package com.educative.algods.crashcourse.binarysearch;

/* Given a boolean array containing only true and false values find the first index of a true value.*/
public class FindbooleanBoundary {
    private static int findBoundary(boolean[] arr){
        if(arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1, mid, currentBoundary = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(arr[mid] == false) left = mid + 1;
            else{
                currentBoundary = mid;
                right = mid -1;
            }
        }
        return currentBoundary;
    }
    public static void main(String[] args){
        System.out.println("Find boundry :" + findBoundary(new boolean[]{false, false, true, true, true}));
        System.out.println("Find boundry :" + findBoundary(new boolean[]{true}));
        System.out.println("Find boundry :" + findBoundary(new boolean[]{false, false, false}));
        System.out.println("Find boundry :" + findBoundary(new boolean[]{true, true, true, true, true}));
        System.out.println("Find boundry :" + findBoundary(new boolean[]{false, true}));
    }
}
