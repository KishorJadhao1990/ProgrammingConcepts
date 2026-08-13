package com.eao.usecases.all;

import java.util.Arrays;
import java.util.function.BiFunction;

public class MergeArrayInSortedOrder {

    public static void main(String[] args) {

        BiFunction<int[], int[], int[]> function = (arr1, arr2) -> {
            int a1len = arr1.length, a2len = arr2.length;
            int []res = new int [a1len + a2len];
            int i = 0, j =0, k= 0;
            while (i < a1len && j < a2len) {
                if (arr1[i] < arr2[j]) {
                    res[k++] = arr1[i++];
                } else {
                    res[k++] = arr2[j++];
                }
            }
            while(i < a1len) {
                res[k++] = arr1[i++];
            }
            while(j < a2len) {
                res[k] = arr2[j++];
            }
            return res;
        };

        int [] res = function.apply(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
        System.out.println(Arrays.toString(res));
    }
}
