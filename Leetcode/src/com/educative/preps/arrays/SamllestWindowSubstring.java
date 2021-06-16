package com.educative.preps.arrays;

import java.util.HashMap;

public class SamllestWindowSubstring {
    private static String findSmallestSubStringWindow(String strInput, String strPattern){
        if(null == strInput || strInput.length() < strPattern.length()) return "";
        int windowStart=0, matchCount = 0, stringLength = Integer.MAX_VALUE, currentLength = 0;
        char currentChar;
        String strSmallestSubString = "";
        //Prepare a token map to store the tokens and frequency of all the characters in the pattern
        HashMap<Character, Integer> tokenMap = new HashMap<Character, Integer>();
        for(char token: strPattern.toCharArray()) tokenMap.put(token, tokenMap.getOrDefault(token, 0) + 1);

        for(int windowEnd=0; windowEnd<strInput.length(); windowEnd++){
            currentChar = strInput.charAt(windowEnd);
            if(tokenMap.containsKey(currentChar)){
                tokenMap.put(currentChar, tokenMap.get(currentChar) - 1);
                // Completely matched all the occurances of the characters hence we are reducing the match count.
                if(tokenMap.get(currentChar) >= 0) matchCount ++;
            }
            //Since we are matching every occurance of character we will compare match count with the length of the pattern.
            while(matchCount == strPattern.length()){
                currentLength = windowEnd - windowStart + 1;
                // Found the minimum length substring hence update the length as well as the substring.
                if(currentLength < stringLength){
                    stringLength = currentLength;
                    strSmallestSubString = strInput.substring(windowStart, windowEnd + 1);
                }
                currentChar = strInput.charAt(windowStart);
                if(tokenMap.containsKey(currentChar)){
                    // We can easily have multiple occurances of same character hence we decrement the matchcount only when we completely handle the duplicates
                    if(tokenMap.get(currentChar) == 0) matchCount --;
                    tokenMap.put(currentChar, tokenMap.get(currentChar) + 1);
                }
                windowStart ++;
            }
        }
        return strSmallestSubString;
    }
    public static void main(String[] args){
        String strInput="abdbca", Pattern="abc";
        String smallestSubString = findSmallestSubStringWindow(strInput, Pattern);
        System.out.println("Window containing smallest substring => "+smallestSubString);
    }
}
