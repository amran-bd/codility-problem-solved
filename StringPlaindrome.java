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
public class StringPlaindrome {

    public static void main(String[] args) {
        String result = "";
        String str = "never odd or even".replaceAll("\\s+", "");
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                result = "F";
            } else {
                result = "T";
            }
        }
        System.out.println(result);

    }
}
