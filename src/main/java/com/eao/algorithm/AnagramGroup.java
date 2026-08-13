package com.eao.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramGroup {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("eat","tea","tan","ate","nat","bat");
        new AnagramGroup().groupByAnagram(list);

        List<List<String>> res = list.stream().collect(Collectors.groupingBy(e -> {
            char[] temp = e.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        })).values().stream().toList();

        System.out.println(res);
    }

    private void groupByAnagram(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();

        list.forEach(e-> {
            char[] temp = e.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (map.containsKey(key)) {
                map.get(key).add(e);
            } else {
                List<String> vals = new ArrayList<>();
                vals.add(e);
                map.put(key, vals);
            }
        });
        System.out.println(map);
    }
}
