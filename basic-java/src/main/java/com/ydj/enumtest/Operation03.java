package com.ydj.enumtest;

/**
 * 推荐，枚举和行为绑定到一起
 */
public enum Operation03 {

    PLUS("+") {
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation03(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);
}
