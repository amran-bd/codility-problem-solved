/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

/**
 *
 * @author amran
 */
public class Anagrams {

    public static void main(String[] args) throws java.lang.Exception {

        //{"apple", "perl"}, this is not anagram
        //{"lemon", "melon"} , this is anagram
        String word1 = "rather";
        String word2 = "harder";
        int anagramSum = solution(word1, word2);
        System.out.println(word1 + ", " + word2 + ": " + anagramSum);
    }

    public static int solution(String A, String B) {
        boolean isAnagram = true;

        if (A.length() != B.length()) {
            isAnagram = false;
        }

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < A.length(); i++) {
            letters[A.charAt(i)]++;
        }

        for (int i = 0; i < B.length(); i++) {
            letters[B.charAt(i)]--;
            if (letters[B.charAt(i)] < 0) {
                isAnagram = false;
            }
        }

        if (!isAnagram) {

            int[] counts = new int[26];
            char a = 'a';
            char[] charArray = A.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                counts[charArray[i] - a]++;
            }

            charArray = B.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                counts[charArray[i] - a]--;
            }

            int sum = 0;
            for (int i = 0; i < counts.length; i++) {
                sum += Math.abs(counts[i]);
            }

            return sum;
        } else {
            return 0;
        }

    }

}
