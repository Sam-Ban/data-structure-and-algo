package practice.linkedlist;

import java.io.*;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node node = new Node(data);
        if (list.head == null) {
            list.head = node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return list;
    }

    public static void printList(LinkedList list) {
        Node current = list.head;

        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String arg[]) {
        LinkedList list = new LinkedList();
        list = insert(list, 11);
        list = insert(list, 22);
        list = insert(list, 33);
        list = insert(list, 44);

        printList(list);
    }
}
