package com.eao.usecases.all;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

//1. Write a Java program to check if a given STRING is a palindrome or not
//2. Write a Java program to check if a given NUMBER is a palindrome or not


public class PalindromeCheck {

    public static void main(String[] args) {
        findPalindromeWord("i am madam lora");
    }

    static void findPalindromeWord(String para) {
        Predicate<String> isWordPalindrome = str -> {
            if (str.length() <= 1) return false;
            return str.equals(new StringBuilder(str).reverse().toString());
        };

        Function<String, String> function = input ->
                Arrays.stream(input.split("\\s"))
                        .filter(isWordPalindrome).findFirst()
                        .get();
        String output = function.apply(para);
        System.out.println("Palindrome word in '"+para+"' : "+ output);
    }
}
