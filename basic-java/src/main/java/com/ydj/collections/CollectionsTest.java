package com.ydj.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p> Date             :2018/9/23 </p>
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
public class CollectionsTest {

    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listStr.add(String.valueOf(i));
        }
        List<String> list = unmodifiableListTest(listStr);

//        list.add("test add exceptions");
    }

    /**
     * Collections.unmodifiableList 返回一个不可修改的集合类型
     * 如果向该返回集合中添加元素则会抛出   java.lang.UnsupportedOperationException 异常
     * @param list
     * @return
     */
    public static List unmodifiableListTest(List list) {
        return Collections.unmodifiableList(list);
    }

}
