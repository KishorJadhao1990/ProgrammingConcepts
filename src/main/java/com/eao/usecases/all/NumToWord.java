package com.eao.usecases.all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumToWord {
    static String [] ones;
    static String [] onesMultiple;
    static String [] tensMultiple;
    static Map<Integer, String> map;
    static StringBuilder sb = new StringBuilder();
    static {
        map = new HashMap<>();
        map.put(3, "hundred");
        map.put(4, "thousand");
        map.put(5, "thousand");
        map.put(6, "lakhs");
        map.put(7, "lakhs");
        map.put(8, "crore");
        map.put(9, "crore");
        ones = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        onesMultiple = new String[]{"eleven", "twel", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        tensMultiple = new String[]{"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eight", "ninety"};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter the number: ");
            try  {
                int num = Integer.parseInt(reader.readLine().trim());
                String res = numberToWord(num, 0).toString();
                System.out.println(num + " -> " + res);
                sb.delete(0, sb.length());
            } catch (NumberFormatException e) {
                System.out.println("Exception: Number more than 9 digit not supported");
            }
        }
    }

    public static StringBuilder numberToWord(int num, int count) {
        int rem, rem2, div;
        if (num == 0) return sb;
        if (count == 0) {
            rem = num % 1000;
            numberToWord(num / 1000, 3);
        } else {
            rem = num % 100;
            count = rem < 10 ? count + 1 : count + 2;
            numberToWord(num / 100, count);
        }
        if (count > 9) throw new NumberFormatException();
        if (rem > 0 && rem < 100) {
            return sb.append(map2DigitNo(rem)).append(" ").append(map.get(count)).append(" ");
        } else if (rem > 99) {
            div = rem / 100;
            rem2 = rem % 100;
            return sb.append(ones[div-1]).append(" ").append(map.get(3)).append(" ").append(map2DigitNo(rem2)).append(" ");
        }
        return sb.append(ones[rem -1]).append(" ").append(map.get(count)).append(" ");
    }

    static StringBuilder map2DigitNo(int num) {
        StringBuilder res = new StringBuilder();
        int div, rem ;
        if (num > 0 && num < 10) {
            return res.append(ones[num -1]);
        } else if (num > 10 && num < 20) {
            return res.append(onesMultiple[(num % 10) - 1]);
        } else {
            div = num / 10;
            rem = num % 10;
            return res.append(tensMultiple[div - 1]).append(" ").append(rem > 0 ? ones[rem - 1] : "");
        }
    }
}
