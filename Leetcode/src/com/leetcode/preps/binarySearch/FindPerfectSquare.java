package com.leetcode.preps.binarySearch;

public class FindPerfectSquare {
    private static boolean isPerfectSquare(int num){
        if(num < 2) return true;
        int left = 2, right=num/2, mid, value;
        while(left<=right){
            mid = (left+right)/2;
            value = mid * mid;
            if(value == num) return true;
            else if(value > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    public static void main(String[] args){
        int num = 16;
        System.out.println("Is "+num+" a perfect square => "+isPerfectSquare(num));
        num = 7;
        System.out.println("Is "+num+" a perfect square => "+isPerfectSquare(num));
    }
}
