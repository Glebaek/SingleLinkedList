package com.gorodkovgleb;

public class ListNode {

    Node head;

    class Node{
        int val;
        Node next;
        Node(int v)
        {
            val = v;
            next = null;
        }
    }

    //adds a node to the end of the linked list
    public void add(int val) {

        if (head == null) {
            head = new Node(val);
            return;
        }

        Node current = head;

        while (current.next != null)
            current = current.next;

        current.next = new Node(val);

    }

    //adds a node to chosen position
    public void add(int val, int pos) {

        if (pos == 1) {

            Node newHead = new Node(val);
            newHead.next = head;
            head = newHead;
            return;

        }

        Node current = head;
        int i = 1;

        while (i != pos - 1) {

            current = current.next;
            i++;

            if (current.next == null)
                return;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;

    }


    public void remove(int pos) {

        if (head == null)
            return;
        if (pos == 1){ head = head.next; return; }

        Node current = head;
        int i = 1;

        while (i <= pos - 2) {

            current = current.next;
            i++;

            if (current.next == null)
                return;
        }

        current.next = current.next.next;

    }

    //returns the value of the middle note (in case of two middle notes, returns the right one)
    public int midNode() {

        if (head == null)
            return 0;

        int i = 1;
        Node current = head;

        while (current.next != null) { current = current.next; i++; }

        current = head;
        i = (i / 2) + 1;
        for (int j = 1; j != i; j++) {
            current = current.next;
        }

        return current.val;
    }

    //finds out if the linked list is palindrome or not ("1, 2, 2, 1" - is palindrome)
    public boolean isPalindrome() {

        Node current = head;
        int size = 1;

        while (current.next != null) {
            current = current.next;
            size++;
        }

        int[] arrayList = new int[size];
        current = head;


        for (int i = 0; i < size; i++) {
            arrayList[i] = current.val;
            current = current.next;
        }

        int counterLeft = 0;
        int counterRight = 0;

        if (size % 2 == 0) {
            counterLeft = (size / 2) - 1;
            counterRight = counterLeft + 1;
        }else {
            counterLeft = size / 2;
            counterRight = counterLeft;
        }

        while (counterLeft >= 0 && counterRight < size) {

            if(arrayList[counterLeft] != arrayList[counterRight])
                return false;

            counterLeft--;
            counterRight++;
        }

        return true;
    }

    //less memory usage
    public boolean isPalindromeLM() {

        Node current = head;
        int size = 1;

        while (current.next != null) {
            current = current.next;
            size++;
        }

        if (size == 1)
            return true;

        current = head;
        Node currentCompare = head;
        int pointFirst;
        int pointSecond;
        int j;
        pointSecond = (int)Math.ceil(size/2.0);
        pointFirst = pointSecond + 1;


        for (int i = 1; i < pointFirst; i++)
            currentCompare = currentCompare.next;

        for (int i = 1; currentCompare != null; i++){

            if (size % 2 != 0)
                j = 1;
            else
                j = 0;

            while (j < (pointSecond - i)) {
                current = current.next;
                j++;
            }

            if (current.val != currentCompare.val)
                return false;

            currentCompare = currentCompare.next;
            current = head;

        }

        return true;
    }


    public void print() {

        Node current = head;

        while(current != null){

            System.out.print(current.val + " ");
            current = current.next;

        }
        System.out.println(" ");
    }

}
