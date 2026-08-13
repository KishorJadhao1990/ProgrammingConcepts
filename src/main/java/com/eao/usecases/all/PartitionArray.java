package com.eao.usecases.all;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionArray {
    static Integer [] transform (Integer [] arr) {
         return Stream.of(arr).collect(Collectors.partitioningBy(e -> (e%2 == 0)))
                .values().stream().flatMap(l -> l.stream()).toArray(Integer[]::new);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(transform(new Integer[]{1,2,3,4,5})));
    }
}
