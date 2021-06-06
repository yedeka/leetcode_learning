package com.educative.preps.arrays;

import java.util.HashMap;

/*
* Given an array of characters where each character represents a fruit and you have  been given 2 baskets. You have to put a unique fruit in each basket such that
* you get maximum number of fruits in the basket. You can not skip a fruit coming your way meaning that fruit needs to be put in a basket.
* */
public class FruitsInBasket {
    private static int friutsInbasketCount(char[] input){
        int k = 2;
        if(input == null || input.length < k) return -1;
        int windowStart = 0, maxCnt = 0;
        char currentFruit, beginningFruit;
        HashMap<Character, Integer> fruitsFrequency = new HashMap<Character, Integer>();
        for(int i=0;i<input.length;i++){
            currentFruit = input[i];
            fruitsFrequency.put(currentFruit, fruitsFrequency.getOrDefault(fruitsFrequency.get(currentFruit), 0) + 1);
            maxCnt++;
            while(fruitsFrequency.size() > 2){
                beginningFruit = input[windowStart];
                fruitsFrequency.put(beginningFruit, fruitsFrequency.get(beginningFruit) - 1);
                if(fruitsFrequency.get(beginningFruit) == 0){
                    fruitsFrequency.remove(beginningFruit);
                }
                maxCnt --;
                beginningFruit ++;
            }
        }
        return maxCnt;
    }
    public static void main(String[] args){
        char[] input = new char[]{'A', 'B', 'C', 'A', 'C'};
        int iMaxFruits = friutsInbasketCount(input);
        System.out.println("Max Fruits in basket => "+iMaxFruits);
    }
}
