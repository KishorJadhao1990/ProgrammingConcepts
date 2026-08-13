package com.eao.datastructure;


import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Sort2DArray {

    public static void main(String[] args) {

        int[][] arr = {{2, 4}, {5, 7}, {1, 3}, {6, 9}};

        Function<int[][], int[][]> sortFunction = arr1 -> {
            int sorted = 0, unsorted = sorted + 1;
            while (unsorted < arr.length) {

                if (arr[sorted][0] > arr[unsorted][0]) {
                    int []temp = arr[sorted];
                    arr[sorted] = arr[unsorted];
                    arr[unsorted] = temp;
                }
                sorted++;
                if (sorted == unsorted) {
                    unsorted++;
                    sorted = 0;
                }
            }
            return arr;
        };

        Consumer<int[][]> printFunction = arr2 ->{
            System.out.print("{");
            Arrays.stream(arr).forEach(a -> System.out.print(Arrays.toString(a) + ", "));
            System.out.println("}");
        };

        printFunction.accept(arr);

        sortFunction.apply(arr);

        printFunction.accept(arr);

        BinaryOperator<Integer> biOp = (num, num2) -> num + num2;

        System.out.println(biOp.apply(3, 6) );;
    }

}
