package com.practice.b_list.b_singlyLinkedList;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFront(new Integer(1));
        list.insertFront(new Integer(2));
        list.insertFront(new Integer(4));

        Node node = list.searchNode(5);
        if (node == null) {
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            list.insertAfter(3, node);
        }
        System.out.println(list.size());
    }
}

class SinglyLinkedList<E> {
    protected Node head;
    private int size;

    SinglyLinkedList() {
        head = null;
        size = 0;
    }

    int search(E target) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            if (target == p.getItem()) {
                return i;
            }
            p = p.getNext();
        }

        return -1;
    }

    Node searchNode(E item) {
        Node p = head;
        while(p != null) {
            if (item.equals(p.getItem())) {
                return p;
            } else {
                p = p.getNext();
            }
        }
        return p;
    }

    void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    void deleteFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        size--;
    }

    void deleteAfter(Node p) {
        if (p == null) {
            throw new NoSuchElementException();
        }

        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    int size() {
        return size;
    }


}

class Node<E> {
    private E item;
    private Node<E> next;

    Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    E getItem() {
        return item;
    }

    Node<E> getNext() {
        return next;
    }

    void setIem(E newItem) {
        item = newItem;
    }

    void setNext(Node<E> newNext) {
        next = newNext;
    }
}

