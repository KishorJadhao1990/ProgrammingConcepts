package com.eao.datastructure;

import java.util.Arrays;

class Stack<T> {

    private Object[] elements;
    private int top;
    private int size;

    public Stack() {
        this.size = 10;
        this.elements = new Object[size];
        this.top = -1;
    }

    public Stack(int size) {
        this.size = size;
        this.elements = new Object[size];
        this.top = -1;
    }

    public Stack(Object[] elements) {
        this.elements = elements;
    }

    public void push(T data) {
        if (elements.length >= size) {
            size += elements.length;
            elements = Arrays.copyOf(elements, size);
        }
        elements[++top] = data;
    }

    public T pop() {
        if (top == -1) {
            return null;
        }
        T topElement = (T) elements[top];
        elements[top--] = null;
        return topElement;
    }

    public T peek() {
        return (T) elements[top];
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println("| "+ elements[i]+ " |");
        }
        System.out.println(" ____");
    }

    public static void main(String[] args) {
        Stack<Integer> ns = new Stack<>(2);
        ns.push(12);
        ns.push(32);
        ns.push(22);
        ns.push(42);
        ns.printStack();
        System.out.println(ns.peek());
        ns.pop();
        ns.pop();
        System.out.println(ns.peek());
        ns.printStack();
    }
}
