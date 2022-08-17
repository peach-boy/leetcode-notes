package com.wxt.leetcode;

public class MergeTwoLists_2 {

    public static void main(String[] args) {
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sentinel = new ListNode();
        sentinel.next = l1;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        while (l1Curr.next != null) {
            while (l2Curr.next != null) {
                if (l2Curr.val >= l1Curr.val) {
                    ListNode temp1 = l1Curr;
                    ListNode temp2 = l2Curr;
                    l1Curr.next = temp2;
                    l1Curr.next.next = temp1.next;
                } else {
                    sentinel.next = l2Curr;
                    l2Curr.next = l1Curr;
                }
                l2Curr = l2Curr.next;
            }
        }
        return null;
    }


    static class ListNode {
        private int val;
        private ListNode next;


        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
