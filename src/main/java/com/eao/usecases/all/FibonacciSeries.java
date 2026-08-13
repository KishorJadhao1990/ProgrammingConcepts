package com.eao.usecases.all;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FibonacciSeries {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1};
        AtomicInteger integer = new AtomicInteger();
        IntStream.rangeClosed(0, 10).mapToObj(e-> {
            integer.set(a[1]);
            a[1] = a[0]+ a[1];
            a[0] = integer.get();
            return new int[]{a[0], a[1]};
        }).forEach(x -> System.out.println(Arrays.toString(x)));

        // second approach;

        Function<Integer, int []> fibonacciFunction = n -> {
            int []arr = new int [n];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2, j = 0, sum; i < n; i++) {
                sum = arr[j] + arr[j++ + 1];
                arr[i] = sum;
            }
            return arr;
        };

        System.out.println("\nFibonacci numbers: "+ Arrays.toString(fibonacciFunction.apply(12)));

        // nth fibonacci number
        Function<Integer, Integer> function = n -> {
            int first = 0, sec = 1, res = 0;
            for (int i = 0; i < n; i++) {
                res = first + sec;
                sec = first;
                first = res;
                if (i == n - 1 ) {
                    return first;
                }
            }
            return -1;
        };
        System.out.println("\nNth no of fibonacci : "+function.apply(5));;
    }
}
