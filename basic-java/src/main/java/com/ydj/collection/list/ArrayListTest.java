package com.ydj.collection.list;

import com.ydj.POJOs.Apple;
import com.ydj.collection.entity.QuChongObj;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add("string");
        list.set(2, null);
        boolean remove = list.removeAll(Collections.singleton(null));
        System.out.println(list.size());
        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    private static List getNullList(){
        return null;
    }

    private static void changeableArgs(String ... str) {
        System.out.println(str.getClass().getName());
        System.out.println(str[0]);
    }

    /**
     * ArrayList 遍历方式一， for 循环
     * @param list
     */
    private static void arrayTraversing01(List list) {
        if(Optional.ofNullable(list).isPresent()) {
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    /**
     * ArrayList 遍历方式二，foreach 循环
     * @param list
     */
    private static void arrayTraversing02(List list) {
        if(Optional.ofNullable(list).isPresent()) {
            for(Object o :
                    list) {
                System.out.println(o);
            }
        }
    }

    /**
     * ArrayList 遍历方式三，foreach 循环 + 条件
     * @param list
     */
    private static void arrayTraversing03(List list) {
        if(Optional.ofNullable(list).isPresent()) {
            for (Object item :
                    list) {
                if (item instanceof Integer) {
                    System.out.println(item);
                }
            }
        }
    }

    /**
     * ArrayList 遍历方式四，lambda + foreach
     * @param list
     */
    private static void arrayTraversing04(List list) {
        Optional.ofNullable(list).get().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * ArrayList 遍历方式五，lambda + stream + forEach
     * @param list
     */
    private static void arrayTraversing05(List list) {
        Optional.ofNullable(list).get().stream().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * ArrayList 遍历方式六， iterator + while 循环
     * @param list
     */
    private static void arrayTraversing06(List list) {
        Iterator iterator = list.iterator();
        System.out.println(iterator.toString());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * ArrayList spliterator test @TODO MORE
     * @param list
     */
    private static void arraySplitor(List list) {
        Optional.ofNullable(list).get().stream().spliterator().trySplit().forEachRemaining((Object o) -> {
            System.out.println(o);
            /*@Override
            public void accept(Object o) {
                System.out.println(o);
            }*/
        });
    }

    /**
     * ArrayList 转 Object[] 数组方式一
     * @param list
     * @return
     */
    private static Object[] listToArray01(List list) {
        return Optional.ofNullable(list).get().stream().toArray();
    }

    /**
     * ArrayList 转 Object[] 数组方式二
     * 当list中元素非常都的时候使用这个，该列表元素将被存储到该数组中
     * @param list
     * @return
     */
    private static Object[] listToArray02(List list) {
        if(Optional.ofNullable(list).isPresent()) {
            Object[] a = {};
            return list.toArray(a);
        }
        return null;
    }

    /**
     * ArrayList 排序(默认升序)
     * @param list
     * @return
     */
    private static List orderList01(List list) {
        Collections.sort(list);
        return list;
    }

    /**
     * ArrayList 排序(自定义排序)
     * @param list
     * @return
     */
    private static List orderList02(List<String> list) {
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        return list;
    }

    /**
     * 分组，将某个值相同的元素划分到同一个集合中，并返回一个Map，key:相同值得值，value:集合
     * @param list
     * @return
     */
    public static Map<Integer, List<Apple>> listGrouping(List<Apple> list) {
        return list.stream().collect(Collectors.groupingBy(Apple::getId));
    }

    /**
     * 去除集合中的所有null对象
     * @param list
     * @return
     */
    public static boolean removeAllNull(List list) {
        return list.removeAll(Collections.singleton(null));
    }


}
