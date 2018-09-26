package com.ydj.random;

import java.util.Random;

public class RandomUtil {

    /**
     * 私有构造方法，不允许被实例化，即使通过反射方式也无法被实例化
     */
    private RandomUtil() {
        throw new AssertionError();
    }

    /**
     * 所有数字，小写字母，大写字母
     */
    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int ALL_CHAR_LENGTH = 62;

    /**
     * 所有大小写字母
     */
    private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int LETTER_CHAR_LENGTH = 52;

    /**
     * 所有数字
     */
    private static final String NUMBER_CHAR = "0123456789";

    private static final int NUMBER_CHAR_LENGTH = 10;

    private static final Random random;

    static {
        random = new Random();
    }

    /**
     * 生成 [0, 9] 的指定位数的纯数字字符串
     *
     * @param length 生成纯数字字符串的长度
     * @return 返回指定位数的纯数字字符串
     */
    public static String getNumberRandom(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((long) (Math.random() * 9 + 1));
        }
        return sb.toString();
    }

    /**
     * 生成 [0, 9] 的指定位数的纯数字字符串
     *
     * @param length 生成纯数字字符串的长度
     * @return 返回指定位数的纯数字字符串
     */
    public static String getNumberRandom2(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR_LENGTH)));
        }
        return sb.toString();
    }

    /**
     * 生成 [0, 9] 和 a -z, A - Z 的组合的指定长度的随机数
     *
     * @param length 指定生成随机数的长度
     * @return 返回指定长度的数字和大小写字母的组合
     */
    public static String getStrNumMix(int length) {
        StringBuilder val = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val.append(String.valueOf(random.nextInt(10)));
            }
        }
        return val.toString();
    }

    /**
     * 生成 [0, 9] 和 a -z, A - Z 的组合的指定长度的随机数
     *
     * @param length 指定生成随机数的长度
     * @return 返回指定长度的数字和大小写字母的组合
     */
    public static String getStrNumMix2(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR_LENGTH)));
        }
        return sb.toString();
    }

    /**
     * 生成只由大小写字母组成的指定长度的随机字符串
     *
     * @param length 指定生成随机字符串的长度
     * @return 返回指定长度的大小写随机字符串
     */
    public static String getUpperAndLowerMix(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR_LENGTH)));
        }
        return sb.toString();
    }

}
