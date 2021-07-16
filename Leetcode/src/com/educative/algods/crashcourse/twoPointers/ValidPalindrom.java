package com.educative.algods.crashcourse.twoPointers;

/*
* Given a string find whether it is a valid palindrom or not
* */
public class ValidPalindrom {
    private static boolean isPalindrom(String strInput){
        int begin = 0, end = strInput.length() - 1;
        while(begin <= end){
            if(strInput.charAt(begin) != strInput.charAt(end)) return false;
            begin++;
            end --;
        }
        return true;
    }
    public static void main(String[] args){
        String strInput = "ABCBA";
        System.out.println(strInput+" is Palindrom "+isPalindrom(strInput));
        strInput = "ABCCBA";
        System.out.println(strInput+" is Palindrom "+isPalindrom(strInput));
        strInput = "A";
        System.out.println(strInput+" is Palindrom "+isPalindrom(strInput));
        strInput = "ABCDEF";
        System.out.println(strInput+" is Palindrom "+isPalindrom(strInput));
        strInput = "ABCDBA";
        System.out.println(strInput+" is Palindrom "+isPalindrom(strInput));
    }
}
