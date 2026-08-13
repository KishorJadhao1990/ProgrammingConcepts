package com.eao.usecases.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamTerminal {

    public static void main(String[] args) {
        Integer [] arr = {2,45,665,89,9};

        var res = Stream.of(arr).count();
        System.out.println("Array : "+ Arrays.toString(arr)+", anyMatch : "+res);

        var res1 = Stream.of(arr).anyMatch(n -> n%2 == 0);
        System.out.println("Array : "+ Arrays.toString(arr)+", anyMatch : "+res1);

        var res2 = Stream.of(arr).allMatch(n -> n%2 == 0);
        System.out.println("Array : "+ Arrays.toString(arr)+", allMatch : "+res2);

        var res3 = Stream.of(arr).noneMatch(n -> n%2 == 0);
        System.out.println("Array : "+ Arrays.toString(arr)+", noneMatch : "+res3);

        var res4 = Stream.of(arr).filter(n -> n%5 == 0).findFirst().get();
        System.out.println("Array : "+ Arrays.toString(arr)+", findFirst : "+res4);

        var res5 = Stream.of(arr).filter(n -> n%5 == 0).findAny().get();
        System.out.println("Array : "+ Arrays.toString(arr)+", findAny : "+res5);

        var res6 = Stream.of(arr).min(Comparator.comparing(Integer::intValue)).get();
        System.out.println("Array : "+ Arrays.toString(arr)+", min : "+res6);

        var res7 = Stream.of(arr).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("Array : "+ Arrays.toString(arr)+", max : "+res7);

        var res8 = Stream.of(arr).mapToInt(Integer::valueOf).sum();
        System.out.println("Array : "+ Arrays.toString(arr)+", sum : "+res8);


    }

}