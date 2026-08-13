package com.eao.algorithm;

import java.util.Arrays;

public class RotateArray {

    private int[] rotateArrayByKthPos(int [] arr, int k) {
        int len = arr.length, temp, ei = len-1;
        for (int i = 0; i < k; i++) {
            temp = arr[ei];
            while (ei > 0) {
                arr[ei] = arr[ei-1];
                ei--;
            }
            arr[ei] = temp;
            ei = len - 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};
        int [] res = new RotateArray().rotateArrayByKthPos(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
