package com.practice.c_stackQueue.b_linkedListStack;

/**
 * Postfix Notation : 후위표기법
 *
 *  A + B                   : A B +
 *  A + B - C               : A B + C -
 *  A + B * C - D           : A B C * + D -
 *  ( A + B ) / ( C - D )   : A B + C D - /
 */

/**
 * 피연산자 : 스택에 PUSH
 * 연산자 : 2회 POP 하여 계산한 후, 그 값을 PUSH
 */

import java.util.Scanner;

public class Postfix {

    private static final int PLUS = 43;
    private static final int MINUS = 45;
    private static final int MULTIPLY = 42;
    private static final int DIVIDE = 47;

    private static final int ONE = 49;
    private static final int NINE = 57;

    private static char[] c;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        c = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
    }

    private static void solve() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < c.length; i++) {
            char character = c[i];

            if (ONE <= character && character <= NINE) {
                stack.push(character - 48);
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();

                if (character == PLUS) {
                    n1 += n2;
                } else if (character == MINUS) {
                    n1 -= n2;
                } else if (character == MULTIPLY) {
                    n1 *= n2;
                } else if (character == DIVIDE) {
                    n1 /= n2;
                }

                stack.push(n1);
            }
        }

        System.out.println(stack.pop());
    }
}
