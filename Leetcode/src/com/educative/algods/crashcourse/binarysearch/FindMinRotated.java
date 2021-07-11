package com.educative.algods.crashcourse.binarysearch;

public class FindMinRotated {
    private static int findRotatedMin(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1, mid, minIndex = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(arr[mid] <= arr[arr.length - 1]){
                minIndex = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return minIndex;
    }
    public static void main(String[] args){
        int[] input = new int[]{0};
        System.out.println("Min of given rotated array is at "+findRotatedMin(input));
        input = new int[]{10,20,30,40,50};
        System.out.println("Min of given rotated array is at "+findRotatedMin(input));
        input = new int[]{30,40,50,10,20};
        System.out.println("Min of given rotated array is at "+findRotatedMin(input));
        input = new int[]{50,40,30,20,10};
        System.out.println("Min of given rotated array is at "+findRotatedMin(input));
    }
}
