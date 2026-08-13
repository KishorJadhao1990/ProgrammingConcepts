package com.eao.usecases.all;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/*
* FizzBuzz: Write a program that prints the numbers from 1 to 100.
* But for multiples of three, print "Fizz" instead of the number and for the multiples of five, print "Buzz".
* For numbers which are multiples of both three and five, print "FizzBuzz".
* */
public class FizzBuzzPrint {

    public static void main(String[] args) {

        Consumer<Integer> consumer = (limit) -> {
            IntStream.rangeClosed(1, limit).forEach(e -> {
                if (e % 5 != 0 && e % 3 != 0){
                    System.out.println(e);
                } else {
                    if (e % 3 == 0) {
                        System.out.print("Fizz");
                    }
                    if (e % 5 == 0) {
                        System.out.print("Buzz");
                    }
                    System.out.println();
                }
            });
        };

        consumer.accept(100);
    }

}
