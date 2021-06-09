package com.educative.preps.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
*  Given a string and a pattern, find all anagrams of the pattern in the given string.
* */
public class StringAnagrams {
    private static List<Integer> findAnagrams(String strInput, String strPattern){
        List<Integer> anagramIndices = new ArrayList<>();
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        char currentChar;
        int windowStart = 0, matched=0;
        // Prepare a frequency map of the pattern characters
        for(int i=0;i<strPattern.length();i++){
            currentChar = strPattern.charAt(i);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
        }
        //Iterate over the input to find pattern.
        for(int windowEnd=0;windowEnd<strInput.length();windowEnd++){
            currentChar = strInput.charAt(windowEnd);
            // Check if the frequency map contains the current character and increment the counter.
            if(frequencyMap.containsKey(currentChar)){
                frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);
                if(frequencyMap.get(currentChar) == 0){
                    matched ++;
                }
            }
            // Add the starting index of the substring matching the pattern
            if(matched == frequencyMap.size()) anagramIndices.add(windowStart);
            // Check if window length is more then shrink the window
            if(windowEnd + 1 >= strPattern.length()){
                currentChar = strInput.charAt(windowStart);
                if(frequencyMap.containsKey(currentChar)){
                    if(frequencyMap.get(currentChar) == 0) matched --;
                    frequencyMap.put(currentChar, frequencyMap.get(currentChar) + 1);
                }
                windowStart ++;
            }
        }
        return anagramIndices;
    }
    public static void main(String[] args){
        String strInput = "ppqp";
        String strPattern = "pq";
        List<Integer> anagramIndices = findAnagrams(strInput, strPattern);
    }
}
