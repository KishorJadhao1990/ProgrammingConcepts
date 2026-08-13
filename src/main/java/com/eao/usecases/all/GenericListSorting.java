package com.eao.usecases.all;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @author kishor
 * Created on 5/8/2023
 */
public class GenericListSorting {
    public static void main(String[] args) {

        new GenericListSorting().sort(getList());
    }

    public void sort (List<String> list) {
        System.out.println(list);
        list.stream()
                .sorted(new GenericComparator())
                .forEach(System.out::println);
    }

    public static List<String> getList() {
        List<String> strings = new ArrayList<>();
        strings.add("0234");
        strings.add("23abc");
        strings.add("21bbc");
        strings.add("21abc");
        strings.add("pqr123");
        strings.add("pqm124");
        strings.add("pqm123");
        strings.add("param");
        strings.add("name");
        strings.add("1234");
        return strings;
    }
}

class GenericComparator implements Comparator<String> {

    public static final String NUMERIC_PATTERN = "^\\d\\d+.?\\d+.?\\d$";
    public static final String ALFA_NUMERIC_PATTERN = "^[a-zA-Z][a-zA-Z0-9]+$";
    public static final String ALFA_NUMERIC_END_WITH_DIGIT_PATTERN = "[a-zA-Z0-9]+[0-9]$";
    public static final String ALFA_NUMERIC_START_WITH_DIGIT_PATTERN = "^[0-9][a-zA-Z0-9]+$";

    @Override
    public int compare(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        if (isNumeric(s1.trim()) && isNumeric(s2.trim())){
            Double n1 = Double.parseDouble(s1);
            Double n2 = Double.parseDouble(s2);
            return n1.compareTo(n2);
        }

        return s1.compareTo(s2);
    }

    private static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(NUMERIC_PATTERN);
        return pattern.matcher(s).matches();
    }

    private static boolean isAlphaNumeric(String s, String matchPattern) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(matchPattern);
        return pattern.matcher(s).matches();
    }

}