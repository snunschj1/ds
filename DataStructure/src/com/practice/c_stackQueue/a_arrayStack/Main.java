package com.practice.c_stackQueue.a_arrayStack;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] argst) {
        ArrayStack<Integer> stack = new ArrayStack<>();



    }
}

class ArrayStack<E> {

    private E s[];
    private int top;

    ArrayStack() {
        s = (E[]) new Object[1];
        top = -1;
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return (top == -1);
    }

    // Todo : peek() : 스택 가장 위의 item 리턴
    E peek() {
        if (isEmpty()) throw new EmptyStackException();

        return s[top];
    }

    // Todo : push(E item) : 스택의 가장 위에 item 삽입
    void push(E item) {
        if (size() == s.length) {
            resize(2 * s.length);
        }
        s[++top] = item;
    }

    // Todo : pop() : 스택의 가장 위의 item을 리턴
    E pop() {
        if (isEmpty()) throw new EmptyStackException();

        E item = s[top];
        s[top--] = null;    // s[top] 이 참조하던 객체가 가비지 컬렉션에 의해 정리

        if (size() > 0 && size() == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    private void resize(int length) {
        Object[] t = new Object[length];

        for (int i = 0; i <= top; i++) {
            t[i] = s[i];
        }

        s = (E[]) t;
    }

}


