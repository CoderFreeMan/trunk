package com.ydj.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  
 *  <p> Date             : 2018/10/30 </p >
 *  <p> Module             : </p >
 *  <p> Description             : </p >
 *  <p> Remark             : </p >
 * <p>
 *  @author yangdejun
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                           </p >
 *  
 */
public class SubListTest {

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            list.add(String.valueOf(i));
        }
        List<String> strings1 = list.subList(0, 4);
        *//*strings1.forEach(item -> {
            System.out.println(item);
        });*//*

        strings1.set(0, "haha");

        list.forEach(item -> {
            System.out.println(item);
        });*/


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }

        /*for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }*/
    }

}
