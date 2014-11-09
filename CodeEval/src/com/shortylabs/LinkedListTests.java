package com.shortylabs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by Jeri on 10/29/14.
 */
public class LinkedListTests {

    public static void main (String[] args) {

        LinkedList<Integer> ll = initList();

        dump(ll);

        ll = removeDups(ll);
        dump(ll);

        ll = initList();
        ll = removeDupsLoop(ll);
        dump(ll);

        ll = initList();
        ll = removeDupsRunners(ll);
        dump(ll);




    }

    private static void dump(LinkedList<Integer> ll) {
        System.out.println("******");
        Iterator<Integer> it = ll.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static LinkedList<Integer>  initList() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(1);
        ll.add(3);
        ll.add(7);
        ll.add(1);
        ll.add(4);
        ll.add(4);
        ll.add(0);
        ll.add(3);
        ll.add(7);
        return ll;
    }


    /**
     * must use LinkedHashSet, not HashSet, to preserve sort order of input list
     * @param ll
     * @return
     */
    private static LinkedList<Integer> removeDups( LinkedList<Integer> ll) {
        return  new LinkedList<Integer>(new LinkedHashSet(ll));

    }

    private static LinkedList<Integer> removeDupsLoop( final LinkedList<Integer> ll) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList<Integer> newList = new LinkedList<Integer>();
        for (int i = 0; i < ll.size(); i++) {
            Integer cur = ll.get(i);
            if (set.add(cur))  {
                newList.add(ll.get(i));
            }
        }
        return newList;
    }

    private static LinkedList<Integer> removeDupsRunners( LinkedList<Integer> ll) {
        for (int i = 0; i < ll.size(); i++) {
            Integer val = ll.get(i);
            for (int j = i+1; j < ll.size(); j++) {
                if (val == ll.get(j)) {
                    ll.remove(j);
                }
            }
        }
        return ll;
    }

}
