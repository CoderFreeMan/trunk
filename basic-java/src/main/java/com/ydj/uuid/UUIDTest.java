package com.ydj.uuid;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Program Name: daily-test
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/7
 *
 * @author yangdejun
 * @version 1.0
 */
public class UUIDTest {

    private static final Logger LOGGER = Logger.getLogger("uuid.UUIDTest");

    private UUIDTest(){}


    public static void main(String[] args) {
        System.out.println(randomUUID());
        System.out.println(fromStringUUID("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
        System.out.println(nameUUIDFromBytes("addia"));
    }

    /**
     * randomUUID,根据系统时间等因素生成UUID，基本上每次生成的都不一样
     * @return
     */
    public static String randomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }

    /**
     * 根据传入参数生成UUID，参数相同，则生成的UUID相同，否则不相同
     * @param fromUUID
     * @return
     */
    public static String fromStringUUID(String fromUUID) {
        UUID uuid = UUID.fromString(fromUUID);
        return uuid.toString();
    }

    /**
     * 根据传入参数生成UUID，参数相同，则生成的UUID相同，否则不相同
     * @param name
     * @return
     */
    public static String nameUUIDFromBytes(String name) {
        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes());
        return uuid.toString();
    }

}
