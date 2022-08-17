package com.wxt.juc;

public class ThreadMethodExample {
    public static void main(String[] args) throws Exception {

        System.out.println("main thread is running");

        Thread thread = new Thread(() -> {
            try {
                System.out.println("sub thread running");
                Thread.sleep(5 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("sub thread  run end");
        });

        thread.start();
        thread.join();

        System.out.println("main thread is end");

    }
}
