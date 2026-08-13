package com.eao.datastructure;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {

    public static void main(String[] args) {
        Queue<Integer> ele = new Queue<>();
        ele.enqueue(1);
        ele.enqueue(12);
        ele.enqueue(9);
        ele.print();
        ele.dequeue();
        ele.print();
    }

    private final List<T> array ;
    private int rear, front;

    Queue(){
        rear = -1;
        front = -1;
        array = new LinkedList<>();
    }
    void enqueue(T t){
        if(front == -1) front++;
        array.add(++rear, t);
    }

    T dequeue() {
        return array.remove(front--);
    }

    void print (){
        array.forEach(System.out::println);
        System.out.println();
    }
}
