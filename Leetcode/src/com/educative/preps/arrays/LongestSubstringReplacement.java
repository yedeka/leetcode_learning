package com.educative.preps.arrays;

import java.util.HashMap;

/*
* Longest substring with same letters after replacement
* */
public class LongestSubstringReplacement {
    private static int longestReplacedSubstring(String strInput, int k){
        if (strInput == null || strInput.length() < k) return -1;
        int windowStart = 0 ,maxLength = 0, maxRepeatCount = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();
        Character currentChar;
        for(int windowEnd = 0;windowEnd<strInput.length();windowEnd++){
            currentChar = strInput.charAt(windowEnd);
            charFrequencyMap.put(currentChar, charFrequencyMap.getOrDefault(currentChar, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, charFrequencyMap.get(currentChar));
            // Shrink the window if the remaining characters i.e. (length - repeatLetterCount) is greater than k which is the max characters to be replaced
            if(windowEnd - windowStart + 1 - maxRepeatCount > k){
                char leftChar = strInput.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                windowStart ++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        String strInput = "aabccb";
        int k = 2;
        int longestSubString = longestReplacedSubstring(strInput, k);
        System.out.println("Longest repeting substring => "+longestSubString);
    }
}
