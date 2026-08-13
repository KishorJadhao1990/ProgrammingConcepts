package com.eao.usecases.all;

import java.util.Arrays;
import java.util.function.BiFunction;

public class ArraySumOfNumber {

    public static void main(String[] args) {

        BiFunction<Integer[], Integer, Integer[]> function = (arr, target) -> {
            int sum = 0, temp = 0 ;
            int mini = 0, maxi = 1;

            do {
                temp = target - arr[mini];

                if(arr[maxi] != temp) {
                    maxi++;
                }
                if (maxi == arr.length - 1) {
                    mini++;
                    maxi = mini + 1;
                }
                sum = arr[mini] + arr[maxi];
            }while (sum != target);
            return new Integer[] {mini, maxi};
        };

        var res = function.apply(new Integer[] {3, 5, 2, 1, 9, 9, 6}, 3);
        System.out.println(Arrays.toString(res));
    }

    public static class App {

        public static void main(String[] args) {

            String para = "poor man moonwalk urbancity";

            Arrays.stream(para.split("\\s")).filter(App::isUnique).forEach(System.out::println);
        }

        private static boolean isUnique(String word) {
            int i = 0, j = 1;
            do{
                char nextChar = word.charAt(j);
                char currentChar = word.charAt(i);
                if (currentChar == nextChar){
                    return false;
                }
                j++;
                if (j == word.length()) {
                    i++;
                    j = i + 1;
                }
                if (i == word.length() - 1 && j == word.length()) {
                    return true;
                }
            }while(i < word.length());
            return false;
        };
    }
}
