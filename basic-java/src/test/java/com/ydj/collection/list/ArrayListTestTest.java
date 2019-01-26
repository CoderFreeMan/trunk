package com.ydj.collection.list;

import com.ydj.POJOs.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ArrayListTestTest {

    @Test
    public void listGroupingTest() {
        List<Apple> appleList = new ArrayList<>();
        Apple a1 = new Apple();
        a1.setId(1);
        Apple a2 = new Apple();
        a2.setId(1);
        Apple a3 = new Apple();
        a3.setId(0);
        Apple a4 = new Apple();
        a4.setId(0);
        Apple a5 = new Apple();
        a5.setCode(2);
        appleList.add(a1);
        appleList.add(a2);
        appleList.add(a3);
        appleList.add(a4);
        Map<Integer, List<Apple>> collect1 = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("========");
    }

}