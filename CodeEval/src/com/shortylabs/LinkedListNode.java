package com.shortylabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeri on 10/29/14.
 */
public class LinkedListNode <T extends Number> {

    private LinkedListNode next = null;
    private T data;

    public LinkedListNode() {}

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void add(T data) {
        LinkedListNode n = this;
        LinkedListNode newNode = new LinkedListNode(data);
        while(n.getNext() != null) {
            n = n.getNext();
        }
        // n is the last node
        n.setNext(newNode);

    }


    public static void main(String[] args) {

        LinkedListNode node = new LinkedListNode(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        node.add(6);
        node.add(7);
        node.add(8);
        node.add(9);
        node.add(10);
        node.add(11);
//        LinkedListNode fromLast = findFromLast(node, 3);  // 5
//        System.out.println(fromLast.getData());
//
//        LinkedListNode byRecursion = recursiveFindFromLast(node, 3, new ArrayList<LinkedListNode>());
//        System.out.println(byRecursion.getData());
//
//        fromLast = findFromLast(node, 1);  // 11
//        System.out.println(fromLast.getData());
//
//        byRecursion = recursiveFindFromLast(node, 1, new ArrayList<LinkedListNode>());
//        System.out.println(byRecursion.getData());
//
//        fromLast = findFromLast(node, 2);  // 10
//        System.out.println(fromLast.getData());
//
//        byRecursion = recursiveFindFromLast(node, 2, new ArrayList<LinkedListNode>());
//        System.out.println(byRecursion.getData());


//        LinkedListNode byRunners = findFromLastUsingRunners(node, 2);
//        System.out.println(byRunners.getData());
//
//        byRunners = findFromLastUsingRunners(node, 0);
//        System.out.println(byRunners.getData());

        dump(node);
        delete(node.getNext().getNext());
        dump(node);






    }

    //
    private static void dump(LinkedListNode head) {
        System.out.println("*****");
        LinkedListNode n = head;
        if (head == null) {
            return;
        }
        while(n.getNext()!= null){
            System.out.println(n.getData());
            n =  n.getNext()  ;
        }

        System.out.println(n.getData());
    }

    /**
     *
     * @param head
     * @param posFromLast 1 is the last position, 2 is the second to last
     * @return
     */
    private static LinkedListNode findFromLast(LinkedListNode head, int posFromLast) {
        LinkedListNode n = head;
        List<LinkedListNode> prevList = new ArrayList<LinkedListNode>();
        prevList.add(n);
        while(n.getNext() != null) {
            n = n.getNext();
            prevList.add(n);
        }
        return prevList.get(prevList.size()-posFromLast);

    }

    private static LinkedListNode<Integer> recursiveFindFromLast(LinkedListNode node, int posFromLast, List<LinkedListNode> prevList) {
        LinkedListNode n = node;
        if (prevList.size() == 0) {
            prevList.add(n);
        }
        if (n.getNext() != null) {
            prevList.add(n.getNext());
            recursiveFindFromLast(n.getNext(), posFromLast, prevList);
        }
        return prevList.get(prevList.size()-posFromLast);

    }

    private static LinkedListNode findFromLastUsingRunners(LinkedListNode node, int posFromLast) {

        LinkedListNode p1 = node;
        LinkedListNode p2 = node;
        for (int i = 0; i < posFromLast-1; i++) {
            if (p1.getNext() != null) {
                p1 = p1.getNext();
            }
        }
        while(p1.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p2;

    }


    // node is passed by value, cannot be swapped : node = next
    private static void delete(LinkedListNode node) {
        if (node == null ) {
            return;
        }
        LinkedListNode next = node.getNext();
        if (next == null) {
            return;
        }
        node.setNext(next.getNext());
        node.setData(next.getData());
    }

}
