package com.eao.datastructure;

import java.util.Arrays;


// https://www.geeksforgeeks.org/bubble-sort/

public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {2, 4, 5, 1, 6, 7, 8, 3};
        System.out.println("BubbleSort before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("BubbleSort after sort: " + Arrays.toString(arr));
    }

    private static void sort(Integer[] arr) {
        int pass = 0, min, max;
        int first = 0, sec = first + 1;
        while (pass-- < arr.length) {
            max = Math.max(arr[first], arr[sec]);
            min = Math.min(arr[first], arr[sec]);
            arr[first] = min;
            arr[sec] = max;
            first++;
            sec++;
            if (sec == arr.length) {
                first = 0;
                sec = first + 1;
            }
        }
    }
}
