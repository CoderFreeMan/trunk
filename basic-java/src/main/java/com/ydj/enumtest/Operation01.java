package com.ydj.enumtest;

/**
 * 不推荐，过于脆弱
 */
public enum Operation01 {

    PLUS, MINUS, TIMES, DIVEDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVEDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }

}
