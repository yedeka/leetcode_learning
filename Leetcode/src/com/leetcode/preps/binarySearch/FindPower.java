package com.leetcode.preps.binarySearch;

/* Given two integers x and n find the power x ^ n*/
public class FindPower {
    private static double fastPower(double x, long n){
        if(n == 0) return 1;
        double half = fastPower(x , n/2);
        if (n % 2 == 0) return half * half;
        else return x * half * half;
    }
    private static double findPower(double x, long n){
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return fastPower(x, n);
    }
    public static void main(String[] args){
        double x = 2;
        long n = 10;
        System.out.println("X =>"+x+" power => "+n+" = "+findPower(x,n));
    }
}
