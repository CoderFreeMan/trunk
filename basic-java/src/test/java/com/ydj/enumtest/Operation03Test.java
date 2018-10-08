package com.ydj.enumtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p> Date             : 2018/10/8 </p>
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
public class Operation03Test {

    @Test
    public void apply() {
        double x = 2;
        double y = 5;
        for (Operation03 op : Operation03.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}