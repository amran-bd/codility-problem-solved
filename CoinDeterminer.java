/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import java.util.Scanner;

/**
 *
 * @author amran
 */
public class CoinDeterminer {

    final int[] coins = new int[]{1, 5, 7, 9, 11};

    int CoinDeterminer(int num) {
        int minCount = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int count = getCoinCount(num, i, j);
                if (count < minCount) {
                    minCount = count;
                }
            }
        }

        return minCount;

    }

    int getCoinCount(int num, int maxCoinIndex, int startCoinIndex) {
        int count = 0;

        if (num >= coins[maxCoinIndex]) {
            num -= coins[maxCoinIndex];
            count++;
        }

        for (int i = startCoinIndex; i >= 0; i--) {
            while (num >= coins[i]) {
                num -= coins[i];
                count++;
            }
        }
        return count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CoinDeterminer c = new CoinDeterminer();
        System.out.print(c.CoinDeterminer(34));
    }

}
