package com.eao.algorithm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopFrequency {

    public static void main(String[] args) {
        int [] nums = new int [] {2,3,7,2,5,6,5,5,7};
        new TopFrequency().findTopFrequencies(3, nums);
        Comparator<Map.Entry<Integer, Long>> comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(comparator).limit(3).map(Map.Entry::getKey).toList();
        System.out.println(list);
    }

    private void findTopFrequencies(int top, int [] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);
        queue.addAll(map.entrySet());

        int [] res = new int[top];
        for (int i = 0; i < top; i++) {
            res[i] = queue.poll().getKey();
        }
        System.out.println(Arrays.toString(res));
    }
}
