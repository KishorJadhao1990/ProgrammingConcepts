package com.eao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListOp {

    public static void main(String[] args) {

        LinkedListOp ops = new LinkedListOp();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        System.out.println(ops.reverseLinkedList(nums));

        List<Integer> nums1 = Arrays.asList(1, 3, 5, 6, 7);
        List<Integer> nums2 = Arrays.asList(2, 4, 6);

        System.out.println(ops.merge2List(nums1, nums2));

    }

    private List<Integer> merge2List(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> res = new ArrayList<>(nums1.size()+nums2.size());
        int fp = 0, sp = 0;
        while (fp < nums1.size() && sp < nums2.size()) {
            if (nums1.get(fp) < nums2.get(sp)) {
               res.add(nums1.get(fp++));
            } else {
                res.add(nums2.get(sp++));
            }
        }
        if (fp != nums1.size()) {
            while(fp < nums1.size()) {
                res.add(nums1.get(fp++));
            }
        }
        if (sp != nums2.size()) {
            while(sp < nums2.size()) {
                res.add(nums2.get(sp++));
            }
        }
        return res;
    }

    private List<Integer> reverseLinkedList(List<Integer> nums) {
        int size = nums.size();
        int startIndex = 0, endIndex = size-1;

        while(startIndex < endIndex) {
            int fnum = nums.get(startIndex);
            int lnum = nums.get(endIndex);
            nums.remove(startIndex);
            nums.add(startIndex++, lnum);
            nums.remove(endIndex);
            nums.add(endIndex--, fnum);
        }
        return nums;
    }
}
