package com.leetcode.preps.arrays;
import java.util.List;
import java.util.ArrayList;

public class findDisappearingNumbers {
    private static List<Integer> findDisappearingNums(int[] nums){
        List<Integer> resultList = new ArrayList<Integer>();
        int index;
        for(int i=0;i<nums.length;i++){
            while(nums[i] != i+1){
                index = nums[i] ;
                if(nums[index - 1] != index ){
                    int temp = nums[i];
                    nums[i] = nums[index-1];
                    nums[index - 1] = temp;
                }else{
                    break;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                resultList.add(i+1);
            }
        }

        return resultList;
    }
    public static void main(String[] args){
        int [] input = new int[]{1,2,3,3,3,3};
        findDisappearingNums(input);

    }
}
