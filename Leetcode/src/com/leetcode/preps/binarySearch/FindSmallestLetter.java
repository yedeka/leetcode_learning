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

    private static char findSmallestGreaterthanTargetSimple(char[] input, char target){
        for(char letter: input){
            if(letter > target) return letter;
        }
        return input[0];
    }

    private static char findSmallestGreaterthanTargetbinarySearch(char[] input, char target){
        int lo = 0,hi = input.length, mid;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            char midChar = input[mid];
            if( midChar <= target) lo= mid + 1;
            else hi = mid;
        }
        return input[lo % input.length];
    }




    public static void main(String[] args){
        char[] input = new char[]{'a','d','g'};
        char target = 'c';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTarget(input, target));
        target = 'j';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTargetSimple(input, target));
        input = new char[]{'c','f','j'};
        target = 'a';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTargetbinarySearch(input, target));
        target = 'j';
        System.out.println("Smallest character greater than "+target+" => "+findSmallestGreaterthanTargetbinarySearch(input, target));


    }
}
