package com.ydj.collection.list;

import java.util.List;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        List vector = new Vector();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        long start = System.currentTimeMillis();
        vectorTraversing01(vector);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void vectorTraversing01(List list) {
        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }


}
