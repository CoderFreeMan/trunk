package com.ydj.design_patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p> Date             :2018/9/25 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class SingletonOfEnumTest {

    @Test
    public void getConnection() {

        DBConnection con1 = SingletonOfEnum.getConnection();
        DBConnection con2 = SingletonOfEnum.getConnection();
        Assert.assertEquals(con1, con2);
    }
}