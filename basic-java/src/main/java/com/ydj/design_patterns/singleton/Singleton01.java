package com.ydj.design_patterns.singleton;

import java.io.Serializable;

/**
 * <p> Date             :2018/9/25 </p>
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
public class Singleton01 implements Serializable {

    private static final long serialVersionUID = 4387036025050325147L;

    /**
     * 类加载时被创建的实例
     */
    private static final Singleton01 INSTANCE = new Singleton01();

    /**
     * 私有的构造方法，只有在类加载时被调用一次
     */
    private Singleton01(){}

    /**
     * 公有的静态的获取实例的方法
     * @return
     */
    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    /**
     * 防止反序列化产生新的对象
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
