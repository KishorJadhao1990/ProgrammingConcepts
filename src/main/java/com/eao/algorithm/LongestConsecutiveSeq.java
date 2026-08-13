package com.eao.algorithm;

import java.util.Arrays;

public class LongestConsecutiveSeq {

    public static void main(String[] args) {
        int [] arr = new int[]{ 3, 2, 8, 6, 5, 7 };
        System.out.println(new LongestConsecutiveSeq().findConsecutiveSeq(arr));
    }

    private int findConsecutiveSeq(int []arr) {
        Arrays.sort(arr);
        int count = 1, maxCount = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]+1 == arr[i+1]) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
