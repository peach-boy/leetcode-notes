package com.wxt.offer;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (stack1.peek() != null) {
                stack2.push(stack1.pop());
            }

            if (stack2.isEmpty()){
                return -1;
            }else {
                return stack2.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
    }
}
