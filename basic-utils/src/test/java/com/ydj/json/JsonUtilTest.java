package com.ydj.json;

import com.ydj.testentity.User;
import org.junit.Test;

import java.util.HashMap;
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
public class JsonUtilTest {

    private static final String json = "{\"name\": \"ydj\"}";

    @Test
    public void jsonToBean() {
        User user = JsonUtil.jsonToBean(json, User.class);
        System.out.println(user.toString());
    }

    @Test
    public void beanToJson() {
        User user = new User();
        user.setName("ydj");
        String s = JsonUtil.beanToJson(user);
        System.out.println(s);
    }

    @Test
    public void jsonToMap() {
        Map map = JsonUtil.jsonToMap(json);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
            System.out.println(k.getClass());
            System.out.println(v.getClass());
        });
    }

    @Test
    public void mapToJson() {
        Map map = new HashMap();
        map.put("name", "ydj");
        String s = JsonUtil.mapToJson(map);
        System.out.println(s);
    }
}