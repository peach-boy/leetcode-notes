package com.wxt.juc;

public class SynchronizedExample {
    private Object lock = new Object();

    public void lock() {

        synchronized (lock) {
            System.out.println("do sth");
        }

        System.out.println("do end");
    }

}
