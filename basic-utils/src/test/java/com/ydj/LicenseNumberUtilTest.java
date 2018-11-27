package com.ydj;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  
 *  <p> Date             : 2018/11/27 </p >
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
public class LicenseNumberUtilTest {

    @Test
    public void addMosaic() throws Exception {
        System.out.println(LicenseNumberUtil.addMosaic("45679876546789098765489", 4, 5));
    }
}