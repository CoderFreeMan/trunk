package com.ydj.json;

import com.alibaba.fastjson.JSON;

/**
 * <p> Date             :2017/10/9 </p>
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
public class JsonUtil {

    /**
     * 私有构造器，防止对象被实例化
     */
    private JsonUtil() {
        throw new AssertionError();
    }

    /**
     * json 转 bean
     * @param json 需要转为bean的json对象
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

}
