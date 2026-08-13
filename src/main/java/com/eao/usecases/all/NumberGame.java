package com.eao.usecases.all;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NumberGame {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(221, 34, 5, 123, 453);
        findMin(nums);
        findMax(nums);

        rotateRightBy1Array(new Integer[]{1, 2, 3, 4, 5});

    }

    private static void rotateRightBy1Array(Integer[] nums) {

        int lastIndex = nums.length -1, temp;
        int secondLastIndex = nums.length -2;
        do {
            temp = nums[secondLastIndex];
            nums[secondLastIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            secondLastIndex--;
            lastIndex--;
        } while(secondLastIndex >= 0);
        System.out.println(Arrays.toString(nums));
    }


    public static Integer findMin(List<Integer> nums) {
        Function<List<Integer>, Integer> findMinFunction = numbers ->
                numbers.stream().reduce(Integer.MAX_VALUE, (n1,n2) -> findMinFunc(n1,n2));

        Integer min = findMinFunction.apply(nums);
        System.out.println("Min num from Array : " + nums + " = "+ min);
        return min;
    }

    public static Integer findMax(List<Integer> nums) {
        Function<List<Integer>, Integer> findMaxFunction = numbers ->
                numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        Integer max = findMaxFunction.apply(nums);
        System.out.println("Max num from Array : " + nums + " = "+ max);
        return max;
    }

    private static Integer findMinFunc(Integer num1, Integer num2) {
        return num1 < num2 ? num1 : num2;
    }
}
