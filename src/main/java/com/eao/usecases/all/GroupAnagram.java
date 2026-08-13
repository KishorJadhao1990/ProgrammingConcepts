package com.eao.usecases.all;

import java.util.*;
import java.util.function.BiPredicate;

public class GroupAnagram {

    public static void main(String[] args) {

        BiPredicate<String, String> anagram = (s1, s2) -> {
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

        String[] words = {"cat", "act", "tac", "dog", "god", "asd", "ttac"};

        Map<String, Set<String>> map = new HashMap<>();

        Arrays.stream(words).forEach(word -> {
            var firstMatchOpt = map.keySet().stream().filter(w -> anagram.test(w, word)).findFirst();
            if (firstMatchOpt.isPresent()) {
                map.computeIfPresent(firstMatchOpt.get(), (k, v)-> {
                    v.add(word);
                    return v;
                });
            } else {
                var set = new HashSet<String>();
                set.add(word);
                map.put(word, set);
            }
        });

        System.out.println(map);
    }

}
