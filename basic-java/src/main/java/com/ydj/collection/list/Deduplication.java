package com.ydj.collection.list;

import com.ydj.collection.entity.QuChongObj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 *  
 *  <p> Date             : 2018/11/21 </p >
 *  <p> Module             : </p >
 *  <p> Description             : </p >
 *  <p> Remark             : </p >
 *  @author yangdj
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                           </p >
 *  
 */
public class Deduplication {

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(item -> {
            System.out.println(item);
        });

        System.out.println("===================================");
        unique.stream().forEach(item -> {
            System.out.println(item);
        });*/


        List<QuChongObj> list = new ArrayList<>();
        QuChongObj o1 = new QuChongObj();
        o1.setId(54);
        o1.setCompanyId("11112222");
        list.add(o1);
        QuChongObj o2 = new QuChongObj();
        o2.setCompanyId("11112222");
        o2.setId(9843);
        list.add(o2);
        System.out.println(list.size());
        ArrayList<QuChongObj> collect = list.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(QuChongObj::getCompanyId))), ArrayList::new));
        System.out.println(list.size());
        System.out.println(collect.size());
    }

}
