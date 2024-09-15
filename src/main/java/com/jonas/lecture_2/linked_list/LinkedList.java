package com.jonas.lecture_2.linked_list;

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

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void printList() {
        Node currNode = head;
        System.out.print("\nLinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null \n");
    }

    public boolean deleteByKey(int key) {
        Node currNode = head, prev = null;

        if (currNode != null && currNode.data == key) {
            head = currNode.next;
            return true;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
            return true;
        }

        return false;
    }

    public boolean deleteAtPosition(int index) {
        Node currNode = head, prev = null;

        if (index == 0 && currNode != null) {
            head = currNode.next;
            return true;
        }

        int counter = 0;
        while (currNode != null) {
            if (counter == index) {
                prev.next = currNode.next;
                return true;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        // Print the list
        list.printList(); // Expected: 1 2 3 4 5

        // Delete by key
        if (list.deleteByKey(3)) {
            System.out.println("3 found and deleted");
        } else {
            System.out.println("3 not found");
        }
        list.printList(); // Expected: 1 2 4 5

        // Delete by key (non-existent)
        if (list.deleteByKey(10)) {
            System.out.println("10 found and deleted");
        } else {
            System.out.println("10 not found");
        }
        list.printList(); // Expected: 1 2 4 5

        // Delete at position
        if (list.deleteAtPosition(2)) {
            System.out.println("2 position element deleted");
        } else {
            System.out.println("2 position element not found");
        }
        list.printList(); // Expected: 1 2 5

        // Delete at position (non-existent)
        if (list.deleteAtPosition(10)) {
            System.out.println("10 position element deleted");
        } else {
            System.out.println("10 position element not found");
        }
        list.printList(); // Expected: 1 2 5
    }
}