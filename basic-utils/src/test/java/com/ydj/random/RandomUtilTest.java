package com.ydj.random;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RandomUtilTest {

    @Test
    public void getNumberRandom() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getNumberRandom(6));
        }
    }

    @Test
    public void getNumberRandom2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getNumberRandom2(6));
        }
    }

    @Test
    public void getStrNumMix() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getStrNumMix(4));
        }
    }

    @Test
    public void getStrNumMix2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getStrNumMix2(4));
        }
    }

    @Test
    public void getUpperAndLowerMix() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.getUpperAndLowerMix(8));
        }
    }
}