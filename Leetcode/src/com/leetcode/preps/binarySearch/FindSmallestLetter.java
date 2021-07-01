package com.leetcode.preps.binarySearch;

public class FindSmallestLetter {
    private static char findSmallestGreaterthanTarget(char[] input, char target){
        boolean[] seen = new boolean[26];
        // Step 1 - Populate the seen array with value as true for the characters in the input array.
        for(char letter: input){
            seen[letter - 'a'] = true;
        }
        // Step 2 - Find out the very first element in the seen array and return it
        while(true){
            target ++;
            // wrap around if target is 'z'
            if(target > 'z') target = 'a';
            if(seen[target - 'a']) return target;
        }
    }
    public static void main(String[] args){
        char[] input = new char[]{'a','d','g'};
        char target = 'c';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTarget(input, target));
        target = 'j';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTarget(input, target));


    }
}
