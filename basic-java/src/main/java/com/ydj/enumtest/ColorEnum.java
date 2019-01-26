package com.ydj.enumtest;

/**
 * <p> Date             :2018/9/26 </p>
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
public enum ColorEnum {

    RED("red", "红色"), GREEN("green", "绿色"), BLUE("blue", "蓝色");

    ColorEnum(String key, String value) {}

    //防止字段值被修改，增加的字段也统一final表示常量
    /*private final String key;
    private final String value;

    private ColorEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }*/

    /*//根据key获取枚举
    public static ColorEnum getEnumByKey(String key) {
        if (null == key) {
            return null;
        }
        for (ColorEnum temp : ColorEnum.values()) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }*/
}
