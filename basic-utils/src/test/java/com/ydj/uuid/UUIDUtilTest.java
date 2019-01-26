package com.ydj.uuid;

import org.junit.Test;

import static org.junit.Assert.*;

public class UUIDUtilTest {

    @Test
    public void getUUID() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUIDUtil.getUUID());
        }
    }

    @Test
    public void getLongUUID() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUIDUtil.getLongUUID());
        }
    }
}