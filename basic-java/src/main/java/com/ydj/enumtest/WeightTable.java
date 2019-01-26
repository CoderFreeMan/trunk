package com.ydj.enumtest;

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
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = 126.124;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.println(p);
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }

    }

}
