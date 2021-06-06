package com.educative.preps.arrays;

import java.util.HashSet;

/*
* Given a string find the length of longest substring without repeating characters.
* */
public class NoRepeatSubstring {
    private static int longestSubString(String strInput){
        int strLength = -1;
        if(strInput == null || strInput.length() == 0) return strLength;
        int windowStart = 0;
        Character currentChar;
        HashSet<Character> visitedSet = new HashSet<Character>();
        for(int i=0;i<strInput.length();i++){
            currentChar = strInput.charAt(i);
            if(visitedSet.contains(currentChar)){
                // An important thing to remember here is we are checking to break the loop upon next character hence we can not subtract 1 to find out length;
                // It has to be windowEnd - windowStart
                strLength= Math.max(strLength, i - windowStart);
                windowStart++;
            }else{
                visitedSet.add(currentChar);
            }
        }
        return strLength;
    }
    public static void main(String[] args){
        String strInput = "abcdaab";
        int maxNonRepeatingLength = longestSubString(strInput);
        System.out.println("Length of longest non repeating String => "+maxNonRepeatingLength);
    }
}
