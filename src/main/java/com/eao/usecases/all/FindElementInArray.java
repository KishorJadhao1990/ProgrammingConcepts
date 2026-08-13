package com.eao.usecases.all;


//Write a Java program to find the second-largest number in an array of integers.

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

public class FindElementInArray {

    public static void main(String[] args) {
        Function<Integer[], Integer> secondLargestNo = numbers ->
                Stream.of(numbers).sorted(Comparator.reverseOrder())
                        .skip(1).findFirst().orElse(-1);
        int result = secondLargestNo.apply(new Integer[]{2, 4, 1, -1, 3, 2});
        System.out.println(result);
    }
}
