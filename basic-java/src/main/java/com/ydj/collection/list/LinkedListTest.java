package com.ydj.collection.list;

import java.util.*;
import java.util.function.Consumer;

public class LinkedListTest {

    public static void main(String[] args) {
        List linkedList = new LinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i + "----" + UUID.randomUUID().toString());
        }
        long start = System.currentTimeMillis();
        linkedListTraversing05(linkedList);
        long end = System.currentTimeMillis();
        System.out.println("time" + (end - start));
    }

    /**
     * LinkedList Traversing method one : for cycle
     *
     * @param list
     */
    private static void linkedListTraversing01(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    /**
     * LinkedList Traversing method two : forEach cycle
     *
     * @param list
     */
    private static void linkedListTraversing02(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            for (Object item :
                    list) {
                System.out.println(item);
            }
        }
    }

    /**
     * LinkedList Traversing method three : Iterator + while cycle
     *
     * @param list
     */
    private static void linkedListTraversing03(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    /**
     * LinkedList Traversing method four : lambda + forEach
     * @param list
     */
    private static void linkedListTraversing04(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            list.forEach(item -> {
                System.out.println(item);
            });
        }
    }

    /**
     * LinkedList Traversing method five : lambda + stream + forEach + cycle
     * @param list
     */
    private static void linkedListTraversing05(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            list.stream().forEach(item -> {
                System.out.println(item);
            });
        }
    }

    /**
     * LinkedList Traversing method six : Optional + iterator + forEachRemaining cycle
     * if list is null will throws java.util.NoSuchElementException
     * @param list
     */
    private static void linkedListTraversing06(List list) {
        Optional.ofNullable(list).get().iterator().forEachRemaining(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    /**
     * LinkedList Traversing method seven : Optional + forEach cycle
     * if list is null will throws java.util.NoSuchElementException
     * @param list
     */
    private static void linkedListTraversing07(List list) {
        Optional.ofNullable(list).get().forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    /**
     * LinkedList Traversing method eight : Optional + stream + forEach cycle
     * if list is null will throws java.util.NoSuchElementException
     * @param list
     */
    private static void linkedListTraversing08(List list) {
        Optional.ofNullable(list).get().stream().forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    /**
     * Optional + lambda + stream + forEach cycle
     * @param list
     */
    private static void linkedListTraversing09(List list) {
        Optional.ofNullable(list).ifPresent(new Consumer<List>() {
            @Override
            public void accept(List list) {
                list.stream().forEach(item -> {
                    System.out.println(item);
                });
            }
        });
    }

    /**
     * spliterator + forEachRemaining : cycle
     * @param list
     */
    private static void linkedListTraversing10(List list) {
        if (Optional.ofNullable(list).isPresent()) {
            list.spliterator().trySplit().forEachRemaining(new Consumer() {
                @Override
                public void accept(Object o) {
                    System.out.println(list);
                }
            });
        }
    }

}
