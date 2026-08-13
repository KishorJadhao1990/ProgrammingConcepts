package com.eao.usecases.all;

import java.util.function.Function;

// Find the Maximum Sub array:
// Given an array of integers, find the contiguous sub array with the largest sum.
// {2, 4, 1, -1, 3, 2}


public class MaxSumSubArray {

    public static void main(String[] args) {
        Function<Integer[], Integer> function = numbers -> {
            int currentSum = 0, maxSum = 0;
            for (Integer num : numbers) {
                currentSum += num;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
            return maxSum;
        };

        int result = function.apply(new Integer[]{2, 4, 1, -5, 3, 9});
        System.out.println(result);
    }
}

/*
*
{2, 4, 1, -5, 3, 9}

num = 2
currentSum = 2
maxSum = 2

num = 4
currentSum = 6
maxSum = 6

num = 1
currentSum = 7
maxSum = 7

num = -5
currentSum = 2
maxSum = 7 (keep max sum)

num = 3
currentSum = 5
maxSum = 7

num = 9
currentSum = 14
maxSum = 14
*/