package com.eao.usecases.all;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicate {

    static int current =-1;
    public static void main(String[] args) {
        Integer []arr = {5, 3, 4, 1, 3, 7, 2, 9, 9, 4};

        // first approach
        int[] res = Stream.of(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue()> 1).mapToInt(Map.Entry::getKey).toArray();

        Integer[] res1 = Stream.of(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().filter(e -> e.getValue()> 1).map(Map.Entry::getKey).toArray(Integer[]::new);
        System.out.println(Arrays.toString(res1));

        //second approach
        Set<Integer> set = new HashSet<>();

        int []res2 = Stream.of(arr).filter(e-> !set.add(e)).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(res2));


        Function<Integer[], Integer[]> function = numbers -> Stream.of(numbers).filter(e -> {
            if (e == current) return false;
            current = e;
            return true;
        }).toArray(Integer[]::new);

        Integer[] a = function.apply(new Integer []{1, 2, 2, 3, 4, 4, 4, 5, 5});
        System.out.println(Arrays.toString(a));
    }


}
