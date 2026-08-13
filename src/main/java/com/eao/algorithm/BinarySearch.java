package com.eao.algorithm;

public class BinarySearch {

    private int findElementInArray(int []arr, int key) throws InterruptedException {

        int si = 0, ei = arr.length-1, mid;

        while(si < ei-1) {
            if (arr[si] == key) {
                return si;
            } else if (arr[ei] == key){
                return ei;
            }

            mid =  (si + ei) / 2;
            if (key >= arr[mid]) {
                si = mid;
            } else {
                ei = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        int [] arr = new int[] {2, 5, 8, 12, 16, 23, 38};
        int index  = new BinarySearch().findElementInArray(arr, 39);
        System.out.println("Element found on index : "+ index);
    }
}
