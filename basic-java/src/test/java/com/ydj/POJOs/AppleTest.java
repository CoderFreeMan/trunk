package com.ydj.POJOs;

import org.junit.Test;

import static org.junit.Assert.*;

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
public class AppleTest {

    @Test
    public void test() {
        Apple apple = new Apple();
        System.out.println(apple.getCode());
        System.out.println(apple.getId());
    }

}