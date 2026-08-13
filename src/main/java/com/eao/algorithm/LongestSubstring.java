package com.eao.algorithm;

public class LongestSubstring {


    public static void main(String[] args) {
        String s = "abcduvwxyzbuvwxyzabcd";
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.findLongestSubstr(s));
    }

    private String findLongestSubstr(String str) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        int i = 0, j = 1;
        while (i < str.length()) {
            while (j < str.length() && str.charAt(i) != str.charAt(j)) {
                j++;
            }
            while(j < str.length() && str.charAt(i) == str.charAt(j)) {
                sb = sb.append(str.charAt(i));
                i++; j++;
            }
            res = res.length() > sb.length() ? res : sb.toString();
            sb.setLength(0);
            j = ++i + 1;
        }
        return res;
    }
}
