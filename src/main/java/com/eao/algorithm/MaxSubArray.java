package com.eao.algorithm;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int [] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int [] res = new MaxSubArray().findMaxSubArray(arr);
        System.out.println(Arrays.toString(res));
    }

    private int[] findMaxSubArray(int[] arr) {
        int maxSum = 0, sum, si = 0, ei = 0, len = arr.length;

        for (int i = 0, j; i < len; i++) {
            j = i+1;
            sum = arr[i];
            while(j < len) {
                sum += arr[j++];
                if (sum > maxSum) {
                    maxSum = sum;
                    si = i;
                    ei = j-1;
                }
            }
        }
        System.out.println(si+" "+ei);
        return Arrays.copyOfRange(arr, si, ei+1);
    }
}
