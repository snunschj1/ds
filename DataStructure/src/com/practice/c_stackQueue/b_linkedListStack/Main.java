package com.practice.c_stackQueue.b_linkedListStack;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {

    }
}

class LinkedListStack<E> {
    private Node<E> top;
    private int size;

    LinkedListStack() {
        top = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    // Todo : peek() 스택의 가장 위의 item return
    E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    // Todo : push(E item) 스택의 가장 위에 item 삽입
    void push(E item) {
        Node newNode = new Node(item, top);
        top = newNode;
        size++;
    }

    // Todo : pop() 스택의 가장 위의 item return
    E pop() {
        if (isEmpty()) throw new EmptyStackException();

        E topItem = top.getItem();
        top = top.getNext(); // top 이 top 바로 아래 항목을 참조
        size--;
        return topItem;
    }
}

class Node<E> {
    private E item;
    private Node<E> next;

    Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    E getItem() {
        return item;
    }

    Node<E> getNext() {
        return next;
    }

    void setItem(E item) {
        this.item = item;
    }

    void setNext(Node<E> next) {
        this.next = next;
    }
}
