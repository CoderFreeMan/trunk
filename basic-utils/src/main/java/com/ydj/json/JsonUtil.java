package com.ydj.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

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

    /**
     * bean 转 json
     * @param o 需要转为 json 的 bean
     * @return 转换后的json对象
     */
    public static String beanToJson(Object o) {
        return JSON.toJSONString(o, true);
    }

    /**
     * json 转 Map
     * @param json 需要转换为Map的json对象
     * @return 转换后的Map对象
     */
    public static Map jsonToMap(String json) {
        return JSONObject.parseObject(json);
    }

    /**
     * map 转 json
     * @param map 需要转为json对象的Map对象
     * @return 转换后的json对象
     */
    public static String mapToJson(Map map) {
        return JSONObject.parseObject(JSON.toJSONString(map)).toJSONString();
    }

}
