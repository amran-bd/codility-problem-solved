/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import static com.read.excel.file.Anagrams.solution;
import java.util.Arrays;

/**
 *
 * @author amran
 */
public class LargestWordFromString {

    public static void main(String[] args) {
        String s = "I love dogs";
        String[] word = s.split(" ");
        String largWords[] = new String[word.length];
        String maxLength = "";
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            String validWord = word[i].replaceAll("[-+.^:,@#!]", "");
            if (validWord.length() > maxLength.length()) {
                maxLength = validWord;
                if (largWords[i] == null || largWords[i - count].length() >= maxLength.length()) {
                    largWords[i - count] = maxLength;
                }
            }
            count++;
        }
        System.out.println(Arrays.toString(largWords));

    }
}
