package com.eao.datastructure;


public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = node;
            return;
        }
        Node<T> travNode = head;
        while (travNode.getNext() != null)  {
            travNode = travNode.getNext();
        }
        travNode.setNext(node);
        size++;
    }

    public void remove(T data) {
        Node<T> travNode = head;
        Node<T> prevNode = null;

        while (travNode.getNext() != null)  {
            if (travNode.data.hashCode() == data.hashCode() && travNode.data.equals(data)){
                prevNode.setNext(travNode.getNext());
                return;
            }
            prevNode = travNode;
            travNode = travNode.getNext();
        }

    }

    public void print() {
        Node<T> travNode = head;
        System.out.print("[ ");
        do  {
            System.out.print(travNode.data + ", ");
            travNode = travNode.getNext();
        } while (travNode != null);
        System.out.println(" ]");
    }



    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        list.print();
        list.remove(2);
        list.print();
    }

}

class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}