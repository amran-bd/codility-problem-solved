/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author amran
 */
public class ParenThesisPermutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(3)));
    }

    public static String[] generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder(2 * n);

        generate(2 * n, 0, 0, result, sb);

        String[] arr = result.toArray(new String[result.size()]);

        return arr;
    }

    public static void generate(int maxLength, int left, int right,
            ArrayList<String> result, StringBuilder sb) {
        if (left + right == maxLength) {
            if (left == right) {
                result.add(sb.toString());
            }
        } else if (left >= right) {
            generate(maxLength, left + 1, right, result, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);

            generate(maxLength, left, right + 1, result, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
