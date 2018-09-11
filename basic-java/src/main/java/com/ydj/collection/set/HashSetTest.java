package com.ydj.collection.set;

import java.util.*;
import java.util.function.Consumer;

public class HashSetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
    }

    // HashSet 遍历方式一，Iterator + while 循环
    public static void hashSetTraversing01(Set set) {
        if(Optional.ofNullable(set).isPresent()) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    // HashSet 遍历方式四，foreach
    public static void hashSetTraversing04(Set set) {
        for(Object item :
                set) {
            System.out.println(item);
        }
    }

    // HashSet 遍历方式三， foreach 循环 + 遍历指定类型
    public static void hashSetTraversing03(Set set) {
        if(Optional.ofNullable(set).isPresent()) {
            for(Object o : set) {
                if(o instanceof Integer) {
                    System.out.println(o);
                }
            }
        }
    }

    // HashSet 遍历方式五，lambda + forEach
    public static void hashSetTraversing05(Set set) {
        Optional.ofNullable(set).get().forEach(item -> {
            System.out.println(item);
        });
    }

    // HashSet 遍历方式六， lambda + stream + forEach
    public static void hashSetTraversing06(Set set) {
        Optional.ofNullable(set).get().stream().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 多线程遍历
     * @param set
     */
    public static void hashSetTraversing07(Set set) {
        Optional.ofNullable(set).get().spliterator().trySplit().forEachRemaining(item -> {
            System.out.println(item);
        });
    }

    /**
     * 多线程遍历
     * @param set
     */
    public static void hashSetTraversing08(Set set) {
        Optional.ofNullable(set).get().stream().spliterator().trySplit().forEachRemaining(item -> {
            System.out.println(item);
        });
    }

    /**
     * HashSet 排序方式一
     * @param set
     * @return
     */
    public static Set orderHashSet(Set set) {
        List list = setToList(set);
        return listToSet(list);
    }

    /**
     * set 排序并返回List
     * @param set
     * @return
     */
    private static List orderHashSetReturnList(Set set) {
        List list = setToList(set);
        Collections.sort(list);
        return list;
    }

    /**
     * set 转数组方式一
     * @param set
     * @return
     */
    public static Object[] setToArrays01(Set set) {

        return null;
    }

    /**
     * HashSet 转 List
     * @param set
     * @return
     */
    public static List setToList(Set set) {
        List list = new ArrayList(set);
        Collections.sort(list);
        return list;
    }

    /**
     * List 转 Set
     * @param list
     * @return
     */
    public static Set listToSet(List list) {
        return new HashSet(list);
    }

}
