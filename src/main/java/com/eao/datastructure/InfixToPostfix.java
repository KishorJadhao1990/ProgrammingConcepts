package com.eao.datastructure;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {

        String infix = "a+b*c-d";      // Postfix : abc*+d-

        String postfix = conversion(infix);

        System.out.println("Infix: "+infix+ " to Postfix: "+ postfix);

    }

    private static String conversion(String infix) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            if (Character.isLetterOrDigit(current)) {
                sb.append(current);
            } else {
                if (!stack.empty()) {
                    stack.push(current);
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                } else {
                    stack.push(current);
                }
            }
        }
        return sb.toString();
    }
}
