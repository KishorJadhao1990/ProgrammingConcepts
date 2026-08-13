package com.eao.usecases.all;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamIntermediate {

    public static void main(String[] args) {

        Integer[] arr = {2, 45, 665, 89, 95, 8};

        var res1 = Stream.of(arr).dropWhile(e -> e % 5 == 0).peek(System.out::println).mapToInt(Integer::intValue).toArray();
        System.out.println("Array : " + Arrays.toString(arr) + ", dropWhile : " + Arrays.toString(res1));

        var res2 = Stream.of(arr).filter(e -> e % 5 == 0).peek(System.out::println).mapToInt(Integer::intValue).toArray();
        System.out.println("Array : " + Arrays.toString(arr) + ", filter : " + Arrays.toString(res2));


    }
}
