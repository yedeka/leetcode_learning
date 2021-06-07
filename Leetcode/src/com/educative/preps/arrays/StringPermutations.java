package com.educative.preps.arrays;

import java.util.HashMap;

/*
* Given a string and a pattern return true if the given string contains any permutations of the given pattern else return false.
* */
public class StringPermutations {
    private static boolean findPattern(String strInput, String strPattern){
        if(strInput == null || strInput.length() == 0) return false;
        boolean isMatchFound = false;
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        char currentChar;
        int windowStart = 0, matchedCount = 0;
        // Populate the frequency map with the frequency of characters from pattern string
        for(int i=0;i<strPattern.length();i++){
            currentChar = strPattern.charAt(i);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar,0) + 1);
        }
        for(int windowEnd=0;windowEnd<strInput.length();windowEnd++){
            currentChar = strInput.charAt(windowEnd);
            if(frequencyMap.containsKey(currentChar)) {
                frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);
                if(frequencyMap.get(currentChar) == 0) matchedCount++;
            }
            if (matchedCount == strPattern.length()) return true;
            // Current window size is greater than pattern length hence shrink the window
            if(windowEnd + 1 >= strPattern.length()){
                char leftChar = strInput.charAt(windowStart);
                if(frequencyMap.containsKey(leftChar)){
                    if(frequencyMap.get(leftChar) == 0){
                        matchedCount --;
                    }
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
                }
                windowStart ++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String strInput = "oidbcaf";
        String strPattern = "abc";
        System.out.println("Does the input string contain pattern => "+findPattern(strInput, strPattern));
        strInput = "odicf";
        strPattern = "dc";
        System.out.println("Does the input string contain pattern => "+findPattern(strInput, strPattern));
    }
}
