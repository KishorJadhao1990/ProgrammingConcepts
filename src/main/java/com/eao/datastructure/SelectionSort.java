package com.eao.datastructure;

import java.util.Arrays;

// https://www.geeksforgeeks.org/selection-sort/

public class SelectionSort {

    public static void main(String[] args) {

        Integer[] arr = {2, 4, 5, 1, 6, 7, 8, 3};

        System.out.println("SelectionSort before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("SelectionSort after sort: " + Arrays.toString(arr));

    }

    public static void sort(Integer[] arr) {
        int pass = 0, comp = pass + 1, min, max;

        while (pass < arr.length - 1) {
            max = Math.max(arr[pass], arr[comp]);
            min = Math.min(arr[pass], arr[comp]);
            arr[pass] = min;
            arr[comp] = max;
            comp++;
            if (comp == arr.length) {
                pass++;
                comp = pass + 1;
            }
        }
    }
}
