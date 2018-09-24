package com.ydj.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> Date             :2018/9/24 </p>
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
public final class BeanUtil {

    /**
     * 私有构造方法
     */
    private BeanUtil() {
    }

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * Java 对象转 Map 集合
     * @param o 需要转换为 Map 集合的对象
     * @return 参数为空是返回 null, 参数不为空时返回转换后的 Map 集合
     */
    public static Map<String, Object> beanToMap(Object o) {
        Map<String, Object> map = new HashMap();
        if (null == o) {
            return map;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            String key;
            Method getter;
            Object value;
            for (PropertyDescriptor property : propertyDescriptors) {
                key = property.getName();
                if (!key.equals("class")) {
                    getter = property.getReadMethod();
                    value = getter.invoke(o);
                    map.put(key, value);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
            logger.error("bean transform map error !!!", e);
        }
        return map;
    }

    /**
     * Map 集合转 Java 对象
     * @param map 需要转换为 Java 对象的 Map 集合
     * @param cls 需要转换为的 Java 对象的 Class
     * @param <T> 泛型
     * @return 两个参数包含 null 时，返回 null, 都不为空时返回 Map 集合转换为 Java 对象后的对象
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> cls) {
        if (null == map || cls == null) {
            return null;
        }
        try {
            T clsObj = cls.newInstance();
            BeanUtils.populate(clsObj, map);
            return clsObj;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            logger.error("map transform bean error !!!", e);
            return null;
        }
    }

}