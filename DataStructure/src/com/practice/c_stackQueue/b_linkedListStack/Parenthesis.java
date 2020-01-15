package com.practice.c_stackQueue.b_linkedListStack;

import java.util.Scanner;

public class Parenthesis {

    private static int[] a;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        a = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                a[i] = 1;
            } else if (c == '{') {
                a[i] = 2;
            } else if (c == '[') {
                a[i] = 3;
            } else if (c == ')') {
                a[i] = -1;
            } else if (c == '}') {
                a[i] = -2;
            } else if (c == ']') {
                a[i] = -3;
            }
        }
    }

    private static void solve() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                // Todo : 이전 아이템과 지금 대기 중인 아이템을 비교한다.
                int prev = stack.peek();

                if (prev * a[i] > 0) {
                    // 괄호 방향 같음 (Push)
                    stack.push(a[i]);
                } else if (prev * a[i] < 0){
                    // 괄호 방향 다름
                    if (prev == -a[i]) {
                        // 괄호 종류 같음 (POP)
                        stack.pop();
                    } else {
                        // 괄호 종류 다름 (에러)
                        throw new RuntimeException("WRONG");
                    }
                }
            } else {
                stack.push(a[i]);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("CORRECT");
        } else {
            // Todo : 스택에 남아있는 아이템이 있으면 에러
            throw new RuntimeException("WRONG");
        }
    }
}
