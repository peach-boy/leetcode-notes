package com.wxt;

import java.util.Deque;
import java.util.LinkedList;

public class Case2_s2 {

    private static volatile int state = -1;

    private static Deque<Integer> stack = new LinkedList();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true && state != 0) {
                if (state == 1) {
                    System.out.println("thread-1");
                }
            }
        }).start();

        new Thread(() -> {
            while (true && state != 0) {
                if (state == 2) {
                    System.out.println("thread-2");
                }
            }
        }).start();

        new Thread(() -> {
            while (true && state != 0) {
                if (state == 3) {
                    System.out.println("thread-3");
                }
            }
        }).start();

        stack.push(0);
        for (int i = 0; i < 50; i++) {
            stack.push(3);
            stack.push(2);
            stack.push(1);
        }

        while (stack.peek() != null) {
            state = stack.pop();
        }
    }

}
