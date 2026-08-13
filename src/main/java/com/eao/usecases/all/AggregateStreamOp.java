package com.eao.usecases.all;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AggregateStreamOp {
    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4};
        Double res = IntStream.of(new int[]{1, 2, 3, 4}).average().getAsDouble();
        System.out.println(res);
        double res1 = (Stream.of(a).reduce(0, Integer::sum) / (double)a.length);
        System.out.println(res1);
    }

}
