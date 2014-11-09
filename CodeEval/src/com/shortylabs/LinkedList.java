package com.shortylabs;

/**
 * Created by Jeri on 10/28/14.
 */
public class LinkedList <T extends Number> {

    private Node head;
    private long count = 0;

    public LinkedList() {
        head = null;

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public long size() {
        return count;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if(count > 0) {
            newNode.setNext(head);
        }
        head = newNode;
        count++;

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);
        Node n = head;
        while(n.getNext() != null) {
            n = n.getNext();
        }

        // n is the current last node
        n.setNext(newNode);
        count++;

    }

    public void addAfter(long index, T data) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index out of range");
        }
        Node<T> newNode = new Node<T>(data);
        Node n = head;
        int i = 0;
        while(i++ < index) {
            n = n.getNext();
        }

        // insert new node after n
        newNode.setNext(n.getNext());
        n.setNext(newNode);
        count++;

    }

    public void addBefore(long index, T data) {
        if (index < 0 | index >= count) {
            throw new IllegalArgumentException("Index out of range");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        addAfter(index - 1l, data);

    }

    public void delete(long index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index out of range");
        }
        Node n = head;
        Node prevNode = null;
        int i = 0;
        while(i++ < index) {
            prevNode = n;
            n = n.getNext();
        }

        // n is the node to delete

        if (index == 0) {
            head = n.getNext();
        }
        else {
            prevNode.setNext(n.getNext());
        }
        count--;

    }

    public Object get(long index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index out of range");
        }
        Node n = head;
        int i = 0;
        while(i++ < index) {
            n = n.getNext();
        }
        return n.getData();
    }




    private static class Node <T extends Number> {

        private Node next = null;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {


        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.addLast(9);


        dump(ll);

        ll.addAfter(2, 4);

        dump(ll);

        ll.addBefore(1, 5);

        dump(ll);

        ll.delete(3);

        dump(ll);

        ll.delete(0);

        dump(ll);

        ll.delete(ll.size()-1);

        dump(ll);


    }

    private static void dump(LinkedList ll) {

        System.out.println("***********");

        if (ll == null || ll.size() < 1) {
            System.out.println("Null or empty linked list");
            return;
        }

        for (long l = 0; l < ll.size(); l++ ) {
            System.out.println(ll.get(l));
        }



    }
}
