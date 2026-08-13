package com.eao.datastructure;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        Integer[] arr = {2, 4, 5, 1, 6, 7, 8, 3};
        Arrays.sort(arr);
        System.out.println(binarySearch(6, arr));
    }

    public static Integer binarySearch(Integer key, Integer[] arr) {
        if (arr.length == 0) return -1;

        int min = 0, max = arr.length-1;

        return binarySearchKey(key, min, max, arr);
    }

    private static Integer binarySearchKey(int key, int min, int max, Integer[] arr) {

        int mid = (min + max) / 2;
        if (key == arr[min]) return min;
        if (key == arr[max]) return max;
        if (key == arr[mid]) return mid;
        else if (key > arr[mid]) {
            return binarySearchKey(key, mid, max, arr);
        } else {
            return binarySearchKey(key, min, mid, arr);
        }
    }
}
