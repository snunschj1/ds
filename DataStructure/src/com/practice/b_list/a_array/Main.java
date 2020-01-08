package com.practice.b_list.a_array;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(1);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(2);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(3);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(4);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(5);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(6);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(7);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(8);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(9);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.insertLast(10);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());

        arr.delete(9);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(8);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(7);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(6);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(5);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(4);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(3);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(2);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(1);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
        arr.delete(0);
        System.out.printf("length = %d, size = %d\n", arr.totalSize(), arr.size());
    }
}

class ArrayList <E> {
    private E[] a;
    private int size;

    ArrayList() {
        a = (E[]) new Object[1];
        size = 0;
    }

    E peek(int k) {
        if (size == 0 || k >= size) {
            throw new NoSuchElementException();
        }
        return a[k];
    }

    void insertLast(E newItem) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = newItem;
    }

    void insert(E newItem, int k) {
        if (size == a.length) {
            resize(2 * a.length);
        }

        for (int i = size - 1; i >= k; i--) {
            a[i+1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    E delete(int k) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E item = a[k];

        for (int i = k; i < size; i++) {
            a[i] = a[i+1];
        }
        size--;

        if (size > 0 && size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++) {
            t[i] = a[i];
        }

        a = (E[]) t;
    }

    int totalSize() {
        return a.length;
    }

    int size() {
        return size;
    }
}
