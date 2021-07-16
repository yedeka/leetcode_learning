package com.educative.algods.crashcourse.twoPointers;

import java.util.HashSet;

/*
* Problem Statement - Given a string find the longest string that can be made without repeating any character.
* Solution - Use two pointer approach with sliding window for completing this.
* Keep track of all the visited characters in a set and when you see a repeating character then start removing characters ponited by left pointer until the
* character pointed by right is out of the window.
* */
public class LongestRepeatingSubstring {
    private static int findLongestString(String strInput){
        int left = 0, right = 0, length=strInput.length(), longest = 0;
        HashSet<Character> visited = new HashSet<>();
        char current, leftChar;
        while(right < length){
            current = strInput.charAt(right);
            if(!visited.contains(current)){
                visited.add(current);
                right ++;
            }else{
                longest = Math.max(longest, right - left);
                while(visited.contains(current)){
                    leftChar = strInput.charAt(left);
                    visited.remove(leftChar);
                    left++;
                }

            }
        }
        return Math.max(longest, visited.size());
    }
    public static void main(String[] args){
        String strInput = "abcdbea";
        System.out.println("Maximum length of non repeating string => "+findLongestString(strInput));
        strInput = "aba";
        System.out.println("Maximum length of non repeating string => "+findLongestString(strInput));
        strInput = "abccabcabcc";
        System.out.println("Maximum length of non repeating string => "+findLongestString(strInput));
    }
}
