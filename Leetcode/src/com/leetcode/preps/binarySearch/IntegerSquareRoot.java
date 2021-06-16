package com.leetcode.preps.binarySearch;

public class IntegerSquareRoot {
    private static int findSquareRoot(int x){
        if (x < 2) return x;
        long square;
        int left = 2, right = x/2, mid;
        while(left <= right){
            mid = left + (right - left )/ 2;
            square = mid * mid;
            if(square > x) right = mid -1;
            else if(square < x) left = mid + 1;
            return mid;
        }
        return right;
    }
    public static void main(String[] args){
        int number = 4;
        int sqrt = findSquareRoot(number);
        System.out.println(" Square root of "+number+" => "+sqrt);
        number = 8;
        sqrt = findSquareRoot(number);
        System.out.println(" Square root of "+number+" => "+sqrt);
    }
}
