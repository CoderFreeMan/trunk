package com.ydj.collection.set;

import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) {

        SortedSet<Object> objects = Collections.synchronizedSortedSet(new TreeSet<>());

        Set treeSet = new TreeSet();

        for (int i = 0; i < 10; i++) {
            treeSet.add(i + UUID.randomUUID().toString());
        }

        treeSetTraversing01(treeSet);
        treeSetTraversing02(treeSet);
        treeSetTraversing03(treeSet);
        treeSetTraversing04(treeSet);
        treeSetTraversing05(treeSet);

    }

    /**
     * TreeSet 遍历方式一， Iterator + while
     * @param set
     */
    private static void treeSetTraversing01(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * TreeSet 遍历方式二， foreach 循环
     * @param set
     */
    private static void treeSetTraversing02(Set set) {
        for (Object o : set) {
            System.out.println(o);
        }
    }

    /**
     * TreeSet 遍历方式三， foreach 循环 + 条件
     * @param set
     */
    private static void treeSetTraversing03(Set set) {
        for (Object o : set) {
            if (o instanceof Integer) {
                System.out.println(o);
            }
        }
    }

    /**
     * TreeSet 遍历方式四，lambda + foreach
     * @param set
     */
    private static void treeSetTraversing04(Set set) {
        set.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * TreeSet 遍历方式五，lambda + stream + forEach
     * @param set
     */
    private static void treeSetTraversing05(Set set) {
        set.stream().forEach(item -> {
            System.out.println(item);
        });
    }



}
