package com.eao.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsecutiveNumber {

    public static void main(String[] args) {
        String s = "12357d78msahgdh89-1-2-3";
        findConsecutiveNumbers(s, 3);
    }

    static void findConsecutiveNumbers(String s, int k) {
        int prevDigit = 99999999;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        Matcher matcher = Pattern.compile("-?\\d").matcher(s);
        while (matcher.find()) {
            Integer digit = Integer.valueOf(matcher.group());
            if (sb.isEmpty() || digit == prevDigit + 1) {
                sb = sb.append(digit);
                prevDigit = digit;
            } else {
                list.add(sb.toString());
                sb.setLength(0);
                sb = sb.append(digit);
                prevDigit = digit;
            }
        }
        list.stream().sorted(Comparator.comparing(String::length).reversed()).map(Integer::parseInt).forEach(System.out::println);
    }
}
