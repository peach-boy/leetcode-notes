package com.wxt.ali;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrossPrintStr_2 {
    private Object lock = new Object();
    private volatile int index = 0;
    public static void main(String[] args) {
        String str = "12A34B56C78D910E1112F1314G1516H1718I1920J2122K";
        char[] charArray=str.toCharArray();

        CrossPrintStr_2 crossPrintStr_2=new CrossPrintStr_2();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            crossPrintStr_2.printNumber(charArray);
        });
        executorService.submit(()->{
            crossPrintStr_2.printLetter(charArray);
        });


    }

    public void printLetter(char[] charArray) {
        while (index < charArray.length) {
            synchronized (lock) {
                char currChar = charArray[index];
                if (Character.isLetter(currChar)) {
                    System.out.println("letter----:" + currChar);
                    index++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printNumber(char[] charArray) {
        while (index < charArray.length) {
            synchronized (lock) {
                char currChar = charArray[index];
                if (Character.isDigit(currChar)) {
                    System.out.println("number----:" + currChar);
                    index++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
