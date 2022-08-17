package com.wxt;

import java.util.concurrent.atomic.AtomicInteger;

public class Case2_s1 {
    private volatile int stag = 1;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        new Case2_s1().threeThreadloopRun();
    }

    public void threeThreadloopRun() {
        new Thread(() -> {
            while (true && stag != 0) {
                if (stag == 1) {
                    if (atomicInteger.get() > 50) {
                        stag = 0;
                        break;
                    }
                    System.out.println("thread-1----" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    stag = 2;
                }
            }
        }).start();

        new Thread(() -> {
            while (true && stag != 0) {
                if (stag == 2) {
                    System.out.println("thread-2");
                    stag = 3;
                }
            }
        }).start();

        new Thread(() -> {
            while (true && stag != 0) {
                if (stag == 3) {
                    System.out.println("thread-3");
                    stag = 1;
                }
            }
        }).start();
    }
}
