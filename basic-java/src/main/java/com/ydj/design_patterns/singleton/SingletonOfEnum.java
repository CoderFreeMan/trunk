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
public enum SingletonOfEnum {

    INSTANCE;

    private static DBConnection connection;

    static {
        connection = new DBConnection();
    }

    public DBConnection getConnection() {
        return connection;
    }
    public static class DBConnection {
        private DBConnection() {

        }
    }
}



