package com.eao.algorithm;

import java.util.Arrays;

public class WordSort {

    public static void main(String[] args) {
        System.out.println(new WordSort().sortCharInWord("silent"));
    }
    private String sortCharInWord(String s) {
        char [] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() -1; j++) {
                int fc = chars[i];
                int sc = chars[j];
                if (fc > sc) {
                    fc = fc + sc;
                    sc = fc - sc;
                    fc = fc - sc;
                    chars[i] = (char) fc;
                    chars[j] = (char) sc;
                }
            }
        }
        return Arrays.toString(chars);
    }
}
