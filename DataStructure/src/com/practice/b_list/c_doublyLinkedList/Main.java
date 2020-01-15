package com.practice.b_list.c_doublyLinkedList;

import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAfter(list.head, 5);
        list.insertAfter(list.head, 4);
        list.insertAfter(list.head, 3);
        list.insertAfter(list.head, 2);
        list.insertAfter(list.head, 1);

        DNode one = list.searchNode(3);
        if (one != null) {
            list.insertBefore(one, 6);
        }

        for (int i = 1; i <= 6; i++) {
            System.out.println(list.search(i));
        }
    }
}


class DoublyLinkedList<E> {
    protected DNode head;
    protected DNode tail;
    protected int size;

    DoublyLinkedList() {
        head = new DNode<>(null, null, null);
        tail = new DNode<>(null, head, null); // tail 이전 노드 -> head
        head.setNext(tail); // head 다음 노드 -> tail
        size = 0;
    }

    DNode searchNode(E target) {
        DNode p = head.getNext();

        for (int i = 0; i < size; i++) {
            if (target == p.getItem()) {
                return p;
            }
            p = p.getNext();
        }

        return null;
    }

    int search(E target) {
        DNode p = head.getNext();

        for (int i = 0; i < size; i++) {
            if (target == p.getItem()) {
                return i;
            }
            p = p.getNext();
        }
        return -1;
    }

    void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrev();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrev(newNode);
        t.setNext(newNode);
        size++;
    }

    void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        p.setNext(newNode);
        t.setPrev(newNode);
        size++;
    }

    void delete(DNode x) {
        if (x == null) {
            throw new NoSuchElementException();
        }
        DNode f = x.getPrev();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrev(f);
        size--;
    }

}

class DNode<E> {
    private E item;
    private DNode prev;
    private DNode next;

    DNode(E newItem, DNode p, DNode n) {
        item = newItem;
        prev = p;
        next = n;
    }

    E getItem() {
        return item;
    }

    DNode getPrev() {
        return prev;
    }

    DNode getNext() {
        return next;
    }

    void setItem(E newItem) {
        item = newItem;
    }

    void setPrev(DNode p) {
        prev = p;
    }

    void setNext(DNode n) {
        next = n;
    }
}