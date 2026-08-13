package com.eao.usecases.all;


import java.util.function.BiFunction;

/*
Given an array of size N-1 such that it only contains
distinct integers in the range of 1 to N.
Find the missing element.
Example
N = 10
A[] = {6,1,2,8,3,4,7,10,5}
Output: 9
*/
public class ArrayMissingNum {

    public static void main(String[] args) {

        BiFunction<Integer[], Integer, Integer> function = (arr, max) ->  {
            int min = 1, index = 0, comp = 1;
            boolean isNext = false, isPrev = false;

            while(index < arr.length){
                int num = arr[index];

                if (num < max && num >= min) {

                    if (arr[comp] == (num + 1)) {
                        isNext = true;
                        comp++;
                    }
                    else if (num > 1 && arr[comp] == (num - 1)) {
                        isPrev = true;
                        comp++;
                    } else {
                        comp++;
                    }
                    if (comp == arr.length && isNext && (num > 1 && !isPrev)) {
                        return num - 1;
                    }
                    else if (comp == arr.length && !isNext && isPrev) {
                        return num + 1;
                    }
                    if (comp == arr.length) {
                        isNext = false;
                        isPrev = false;
                        index++;
                        comp = 0;
                    }
                }
            }

            return -1;
        };

        System.out.println(function.apply(new Integer[] {6,1,2,8,3,4,7,10,5}, 10));;

    }
}
