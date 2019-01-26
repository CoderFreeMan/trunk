package com.ydj.uuid;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 私有构造方法，防止被实例化
     */
    private UUIDUtil() {
        throw new AssertionError();
    }

    /**
     * 获取MostSignificatBits类型的UUID
     * @return
     */
    public static String getUUID() {
        long uuid;
        do {
            uuid = UUID.randomUUID().getMostSignificantBits();
        } while (uuid <= 0L);
        return uuid + "";
    }

    /**
     * 获取Long类型的UUID
     * @return
     */
    public static long getLongUUID() {
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }

}
