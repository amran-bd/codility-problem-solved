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
public class StringSubTractOddEven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(solution("011100"));
        System.out.println(solution("111"));
        System.out.println(solution("1111010101111"));
        System.out.println(solution("1"));
    }

    public static int solution(String s) {
        int firstOneAt = s.indexOf("1");
        return firstOneAt == -1 ? 0
                : s.replace("0", "").length() + s.length() - firstOneAt - 1;
    }

}
