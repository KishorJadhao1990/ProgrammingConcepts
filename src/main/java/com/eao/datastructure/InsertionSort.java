package com.eao.datastructure;


// https://www.geeksforgeeks.org/insertion-sort/

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 5, 1, 6, 7, 8, 3};
        System.out.println("InsertionSort before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("InsertionSort after sort: " + Arrays.toString(arr));
    }

    private static void sort(Integer[] arr) {

        int sorted = 0, unsorted = sorted + 1, min, max;

        while (unsorted < arr.length) {
            max = Math.max(arr[sorted], arr[unsorted]);
            min = Math.min(arr[sorted], arr[unsorted]);
            arr[sorted] = min;
            arr[unsorted] = max;

            if (sorted < unsorted) {
                sorted++;
            } else {
                unsorted++;
                sorted = 0;
            }
        }

    }
}
