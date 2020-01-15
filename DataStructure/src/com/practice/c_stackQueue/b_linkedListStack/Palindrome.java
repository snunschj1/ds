package com.practice.c_stackQueue.b_linkedListStack;

import java.util.Scanner;

/**
    회문(Palindrome) : 앞으로부터 읽으나 뒤로부터 읽으나 같은 문자열
 */

public class Palindrome {

    private static String s;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
    }

    private static void solve() {
        LinkedListStack<Character> stack = new LinkedListStack<>();

        // Todo : 문자열의 절반을 스택에 PUSH
        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(i);
            stack.push(c);
        }

        // Todo : 남은 부분과 스택의 pop() 한 아이템을 비교
        for (int i = (s.length() / 2) + (s.length() % 2); i < s.length(); i++) {
            if (stack.pop() != s.charAt(i)) {
                throw new RuntimeException("WRONG");
            }
        }

        System.out.println("Palindrome");
    }
}
