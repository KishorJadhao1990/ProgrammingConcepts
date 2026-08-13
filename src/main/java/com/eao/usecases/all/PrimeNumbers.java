package com.eao.usecases.all;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {
        Function<Integer, int[]> function = range -> IntStream.rangeClosed(0, range).filter(PrimeNumbers::isPrime).toArray();
        System.out.println(Arrays.toString(function.apply(100)));
    }

    private static boolean isPrime(int num) {
        int div = num;
        if (num == 0 || num == 1) return false;
        while (--div >= 2) {
            if (num % div == 0) return false;
        };
        return true;
    }
}
