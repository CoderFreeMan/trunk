package com.ydj.enumtest;

/**
 * 推荐，枚举和行为绑定到一起
 */
public enum Operation02 {

    PLUS {
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS {
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES {
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE {
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);
}
