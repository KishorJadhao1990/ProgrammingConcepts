package com.eao.datastructure;

public class LinearSearch {

    public static void main(String[] args) {

        Integer[] arr = {2, 4, 5, 1, 6, 7, 8, 3};
        System.out.println(search(1, arr));
    }


    public static Integer search(Integer key, Integer[] arr) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) return i;
        }
        return -1;
    }
}
