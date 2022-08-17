package com.wxt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Case4 {
    public static void main(String[] args) {
        List list = new ArrayList<>(5);
        list.add("C");
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("E");

        new Case4().dispatcher(list);
    }

    public void dispatcher(List<String> list) {
        ListNode head = buildChain();
        for (String taskName : list) {
            ListNode currNode = head;
            while (currNode != null) {
                if (Objects.equals(currNode.getTaskName(), taskName)) {
                    System.out.println(taskName + "--处理人是--：" + currNode.getStudentName());
                    break;
                } else {
                    System.out.println( "-------"+currNode.getStudentName()+ "------->：" + currNode.nextNode.getStudentName());
                    currNode = currNode.nextNode;
                }
            }
        }

    }

    public ListNode buildChain() {
        ListNode nodeA = new ListNode("S_A", "A");
        ListNode nodeB = new ListNode("S_B", "B");
        ListNode nodeC = new ListNode("S_C", "C");
        ListNode nodeD = new ListNode("S_D", "D");
        ListNode nodeE = new ListNode("S_E", "E");
        nodeD.nextNode = nodeE;
        nodeC.nextNode = nodeD;
        nodeB.nextNode = nodeC;
        nodeA.nextNode = nodeB;
        return nodeA;
    }

    class ListNode {
        private String studentName;
        private String taskName;
        private ListNode nextNode;

        public ListNode(String studentName, String taskName) {
            this.studentName = studentName;
            this.taskName = taskName;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }
}
