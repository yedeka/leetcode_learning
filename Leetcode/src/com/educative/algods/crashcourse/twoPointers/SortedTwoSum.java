package com.educative.algods.crashcourse.twoPointers;

public class SortedTwoSum {
    private static int[] findTwoSum(int[] nums, int target){
        int[] solution = new int[2];
        int begin = 0, end = nums.length - 1, beginValue, endValue;
        while(begin < end){
            beginValue = nums[begin];
            endValue = nums[end];
            if(beginValue + endValue > target) end --;
            else if(beginValue + endValue < target) begin ++;
            else {
                solution[0] = begin;
                solution[1] = end;
                break;
            }
        }
        return solution;
    }


    public static void main(String[] args){
        int[] nums = new int[]{2,3,4,5,8,11,18};
        int[] solution = findTwoSum(nums, 8);
        System.out.println("The Two sum indices are "+solution[0]+" ,"+solution[1]);
        solution = findTwoSum(nums, 16);
        System.out.println("The Two sum indices are "+solution[0]+" ,"+solution[1]);
    }
}