/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author amran
 */
public class ServerLoadExperience {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] arry = new String[9];
        arry[0] = "0 A created";
        arry[1] = "1 B created";
        arry[2] = "10 A running";
        arry[3] = "12 B waiting";
        arry[4] = "13 B running";
        arry[5] = "14 A waiting";
        arry[6] = "17 B terminated";
        arry[7] = "18 A terminated";
        arry[8] = "15 C running";
        System.out.println(solution(15, arry));
    }

    public static String solution(int t, String[] logs) {
        int temp = Integer.MAX_VALUE;
        String finalStr = null;
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].split(" ")[2].equals("running")) {
                subList.add(logs[i]);
            }
        }
        for (String str : subList) {
            String[] subSubArry = str.split(" ");
            if (t - Integer.valueOf(subSubArry[0]) < temp) {
                finalStr = str;
                temp = t - Integer.valueOf(subSubArry[0]);
            }
        }
        if (null != finalStr) {
            return finalStr.split(" ")[1];
        }

        return "-1";
    }
}
