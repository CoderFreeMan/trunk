package com.ydj.fastjsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ydj.POJOs.Apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  
 *  <p> Date             : 2018/10/23 </p >
 *  <p> Module             : </p >
 *  <p> Description             : </p >
 *  <p> Remark             : </p >
 * <p>
 *  @author yangdejun
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                                     </p >
 *  
 */
public class FastJsonTest {

    public static void test() {

        List<Apple> list = new ArrayList<>();
        Apple a1 = new Apple();
        a1.setId(1);
        Apple a2 = new Apple();
        a2.setId(2);
        list.add(a1);
        list.add(a2);
        String jsonStr = JSON.toJSONString(list);
//        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray objects = JSONObject.parseArray(jsonStr);
        String s = JSONObject.toJSONString(objects.get(0));
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(objects.get(0)));
        Object id = jsonObject.get("id");
//        ((JSONObject) objects.get(0)).get("id");
        System.out.println(jsonStr);
        System.out.println(objects);
    }

    private static void test2() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aaa", "aaa");
        paramMap.put("bbb", "bbb");
        paramMap.put("ccc", "ccc");
        paramMap.put("ddd", "ddd");
        String s = JSON.toJSONString(paramMap);
        System.out.println(s);
    }

    public static void main(String[] args) {
//        test();
        test2();
    }



}
