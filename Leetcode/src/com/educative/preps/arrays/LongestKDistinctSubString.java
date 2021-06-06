package com.educative.preps.arrays;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class LongestKDistinctSubString {
    private static int findLongestSubString(String strInput, int k){
        if(strInput == null || strInput.length() < k) return 0;
        // We will maintain a Hashmap of each character's frequency. When the Hashmap's size exceeds k we will shrink the window.
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        int windowStart=0, windowEnd=0, maxLength=0;
        char currentChar, leftChar;
        while(windowEnd < strInput.length()){
            currentChar = strInput.charAt(windowEnd);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar,0)+1);
            while(frequencyMap.size() > k){
                leftChar = strInput.charAt(windowStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                if(frequencyMap.get(leftChar) == 0) frequencyMap.remove(leftChar);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart + 1);
            windowEnd++;
        }
        return maxLength;
    }
    public static void main(String[] args){
        String strInput = "araaci";
        int k = 2;
        int iLongestSS = findLongestSubString(strInput, k);
        System.out.println("Longest substring of given unique characters length => "+iLongestSS);

    }
}
