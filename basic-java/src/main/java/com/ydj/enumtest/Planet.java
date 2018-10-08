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
public enum Planet {

    MERCURY(3.302e+23, 2.439e6),
    VALUE(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 4.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTRUNE(1.024e+26, 2.477e7);
    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass;
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
