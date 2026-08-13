package com.eao.usecases.all;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/*
0 * 10 + 2 = 2
2 * 10 + 1 = 21
21 * 10 + 1 = 211
211 * 10 + 2  2112
*/

public class Reverse {

    public static void main(String[] args) {
        reverseStr();
        reverseNumber();

        Integer [] arr = {4, 5, 7, 8, 9};
        reverseArray(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseNumber() {
        Function<Integer, Integer> function = input -> {
            int rem = 0, div = input, rev = 0;
            rem = div % 10;
            do {
                rem = div % 10;
                div = div / 10;
                rev = rev * 10 + rem;
            } while(div > 0);
            return rev;
        };
        System.out.println(function.apply(24113));
        Predicate<Integer> predicate = num -> function.apply(num).equals(num);
        System.out.println(predicate.test(21132));

    }

    static void reverseStr() {
        Function<String, String> function = (input) -> {
            int index = input.length();
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(input.charAt(--index));
            } while (index > 0);
            return sb.toString();
        };
        System.out.println(function.apply("JavaLang"));
    }

    static void reverseArray(Integer [] arr, int len) {
        int i = (len % 2 == 0) ? len/2 - 1 : len/2, j = len / 2, temp;
        do {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } while (i-- > 0 && j++ < len);
    }
}
