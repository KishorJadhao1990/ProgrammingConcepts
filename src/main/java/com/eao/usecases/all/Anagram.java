package com.eao.usecases.all;

import java.util.*;
import java.util.function.BiPredicate;

public class Anagram {

    public static void main(String[] args) {

        BiPredicate<String, String> predicate = (s1, s2) -> {
            if (s1.length() != s2.length()) return false;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            Arrays.sort(c1);  //O(n log n)
            Arrays.sort(c2);

            for (int i = 0; i < s1.length(); i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        };

        boolean res = predicate.test("aabb", "abaa");
        System.out.println("IsAnagram :"+ res);

        // second approach
        BiPredicate<String, String> predicate1 = (s1, s2) -> {
            if (s1.length() != s2.length()) return false;
            Set<Integer> ns = new HashSet<>();

            int i = 0, j = 0;

            do {
                if (!ns.contains(j) && s1.charAt(i) == s2.charAt(j)) {
                    ns.add(j);
                    i++;
                    j = 0;
                } else {
                    j++;
                    if (j == s2.length()) {
                        return false;
                    }
                }
            } while (i <= s1.length() - 1);
            return ns.size() == s1.length();
        };

        boolean res1 = predicate1.test("aabb", "abaa");
        System.out.println("IsAnagram1 :"+ res1);


        boolean res2 = predicate1.test("aaacccbb", "ababcacc");
        System.out.println("IsAnagram2 :"+ res2);

    }
}
