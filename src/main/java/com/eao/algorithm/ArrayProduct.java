package com.eao.algorithm;

import java.util.Arrays;

public class ArrayProduct {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4};

        int []res = new ArrayProduct().productExceptSelf(arr);
        System.out.println(Arrays.toString(res));
    }

    private int[] productExceptSelf(int[] arr) {
        int len = arr.length;
        int []res = new int [len];
        for (int i = 0; i < len; i++) {
            int j = i-1;
            int k = i+1;
            res[i] = 1;
            while (k < len) {
                res[i] *= arr[k++];
            }
            while (j > 0) {
                res [i] *= arr[j--];
            }
        }
        return res;
    }
}
