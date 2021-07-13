package com.educative.algods.crashcourse.binarysearch;

public class FindPeakOfMountain {
    private static int findMountainPeak(int[] nums){
        if (nums == null || nums.length < 3)  return -1;
        int left = 0, right = nums.length -1, mid, peakIndex = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            //You have reached till the last element of the array hence there is no peak.
            if(mid == nums.length - 1 || mid == 0 ) return -1;
            if(nums[mid] > nums[mid+1]){
                peakIndex = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return peakIndex;
    }
    public static void main(String[] args){
        int [] nums = new int[]{0,1,2,3,2,1};
        System.out.println("Peak of Mountain index for give array => "+findMountainPeak(nums));
        nums = new int[]{10,5,9};
        System.out.println("Peak of Mountain index for give array => "+findMountainPeak(nums));
        nums = new int[]{1,2,3,4,5,6};
        System.out.println("Peak of Mountain index for give array => "+findMountainPeak(nums));
        nums = new int[]{10,9,8,7,11,45};
        System.out.println("Peak of Mountain index for give array => "+findMountainPeak(nums));
        nums = new int[]{1,2,2,2,2,2,2,3,2,1};
        System.out.println("Peak of Mountain index for give array => "+findMountainPeak(nums));
    }
}
