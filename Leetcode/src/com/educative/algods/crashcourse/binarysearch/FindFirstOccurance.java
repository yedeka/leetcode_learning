package com.educative.algods.crashcourse.binarysearch;

public class FindFirstOccurance {
    private static int findFirstOccurance(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;
        int left =0, right = arr.length - 1, mid, targetIndex = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(arr[mid] == target){
                targetIndex = mid;
                right = mid - 1;
            }else if(arr[mid] < target) left = mid + 1;
            else right = mid -1;
        }
        return targetIndex;
    }
    public static void main(String[] args){
        int [] arr = new int[]{1, 3, 3, 3, 3, 6, 10, 10, 10, 100};
        int target = 3;
        System.out.println("First occurance of "+target+" in given array "+findFirstOccurance(arr, target));

        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        target = 1;
        System.out.println("First occurance of "+target+" in given array "+findFirstOccurance(arr, target));

        arr = new int[]{1, 22, 22, 33, 50, 100, 20000};
        target = 33;
        System.out.println("First occurance of "+target+" in given array "+findFirstOccurance(arr, target));

        arr = new int[]{4, 6, 7, 7, 7, 20};
        target = 8;
        System.out.println("First occurance of "+target+" in given array "+findFirstOccurance(arr, target));
    }
}
