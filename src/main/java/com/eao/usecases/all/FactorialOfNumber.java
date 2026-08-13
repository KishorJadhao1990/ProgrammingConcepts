package com.eao.usecases.all;

// factorial of 4 = 4 * 3 * 2 * 1 = 24

import java.util.function.Function;

public class FactorialOfNumber {

    public static void main(String[] args) {
        Function<Integer, Integer> factorialFun = number -> {
            int prod = number;
            do {
                prod *= --number;
            } while(number > 1);
            return prod;
        };
        int result = factorialFun.apply(5);
        System.out.println(result);
    }
}
