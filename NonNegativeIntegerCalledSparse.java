/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import java.util.ArrayList;

/**
 *
 * @author amran
 */
public class NonNegativeIntegerCalledSparse {

    public static void main(String args[]) {
        int n = 38;
        System.out.println(convertToBinaryString(n));
        int nextSparse = getNextBiggerSparseNumber(n);
        System.out.println(nextSparse);
//        System.out.println(convertToBinaryString(nextSparse));
    }

    public static int getNextBiggerSparseNumber(int n) {
        if (isSparseBinaryNumber(n)) {
            int i = getFirstIndexSeqZeros(n);
            if (i != -1) {
                if (i - 1 == 0) {
                    return n + 1;
                }

                return incrementToNextSparseFromZeroIndex(n, i - 1);

            } else {
                return 1 << getLengthBits(n);
            }
        } else {
            int i = getLastIndexSeqOnes(n);
            return incrementToNextSparseFromIndex(n, i);
        }

    }

    public static int incrementToNextSparseFromZeroIndex(int n, int index) {
        int i = index - 1;
        int n2 = n;
        n2 = setBit(n2, index, true);
        while (i >= 0) {
            n2 = setBit(n2, i, false);
            i--;
        }
        return n2;
    }

    public static int incrementToNextSparseFromIndex(int n, int index) {
        int i = 0;
        int n2 = n;
        boolean prev = false, current = false;

        while (i <= index) {
            n2 = setBit(n2, i, false);
            i++;
        }
        n2 = setBit(n2, i, true);
        prev = true;
        i++;
        current = getBit(n2, i);

        while (current && prev && n2 > 0 || (n2 < n && n2 > 0)) {
            n2 = setBit(n2, i - 1, false);
            n2 = setBit(n2, i, true);
            i++;
            prev = current;
            current = getBit(n2, i);
        }
        if (n2 == 0) {
            return 1 << getLengthBits(n);
        }

        return n2;
    }

    public static int getFirstIndexSeqZeros(int n) {
        // current and previous bit if set to 0 then true
        boolean cur, prev = false;

        int i = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                cur = true;
            } else {
                cur = false;
            }
            if (cur && prev) {
                return i;
            }
            prev = cur;

            i++;
            n = n >> 1;
        }

        return -1;
    }

    public static int getLastIndexSeqOnes(int n) {
        // current and previous bit if set to 1 then true
        boolean cur, prev = false;

        int i = 0;
        int highest = -1;

        while (n > 0) {
            if ((n & 1) == 1) {
                cur = true;
            } else {
                cur = false;
            }
            if (cur && prev) {
                highest = i;
            }
            prev = cur;

            i++;
            n = n >> 1;
        }

        return highest;
    }

    public static boolean isSparseBinaryNumber(int n) {
        // current and previous bit if set to 1 then true
        boolean cur, prev = false;

        while (n > 0) {
            if ((n & 1) == 1) {
                cur = true;
            } else {
                cur = false;
            }
            if (cur && prev) {
                return false;
            }
            prev = cur;

            n = n >> 1;
        }

        return true;
    }

    public static int getLengthBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n >> 1;
        }
        return count;
    }

    public static String convertToBinaryString(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if ((n & 1) == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            n = n >> 1;
        }

        return sb.reverse().toString();
    }

    public static boolean getBit(int n, int index) {
        return ((n & (1 << index)) > 0);
    }

    public static int setBit(int n, int index, boolean b) {
        if (b) {
            return n | (1 << index);
        } else {
            return n & ~(1 << index);
        }
    }
}
