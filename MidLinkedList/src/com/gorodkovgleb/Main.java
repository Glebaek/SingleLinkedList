package com.gorodkovgleb;

public class Main {

    public static void main(String[] args) {

        ListNode list = new ListNode();

        list.add(2,1);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(2);

        list.print();

        if(list.isPalindrome())
            System.out.println("It is a palindrome");
        else
            System.out.println("It is NOT a palindrome");

        System.out.println("Middle node is: " + list.midNode());

    }
}


